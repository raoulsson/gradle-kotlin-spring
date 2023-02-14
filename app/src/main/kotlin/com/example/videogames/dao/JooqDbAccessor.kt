package com.example.videogames.dao

import com.example.videogames.dto.GameAndGenreDTO
import com.example.videogames.dto.TopSellersByPlatformDTO
import jakarta.persistence.EntityManager
import org.jooq.*
import org.jooq.conf.ParamType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.math.BigDecimal

/**
 * https://stackoverflow.com/questions/26889970/intellij-incorrectly-saying-no-beans-of-type-found-for-autowired-repository#comment124095794_41766552
 */
@Component
class JooqDbAccessor(
    private val dsl: DSLContext,
    private val jpaEntityManager: EntityManager,
    private val sqlBuilder: SqlBuilder
) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    /**
     * Create a native query with jooq. Then use the SqlResultSetMapping to map the result to a dto (GameAndGenre)
     * Saves us from doing the mapping manually. And increases Performance. Useful for read-only queries.
     * If CrUD is needed later, use jpa by the entity's ID.
     */
    fun getGamesOrderByGenreName(limit: Int?): MutableList<GameAndGenreDTO>? {
        // "as" is a kotlin keyword and exists in jooq dsl: https://github.com/jOOQ/jOOQ/issues/6361
        val selectQuery: SelectQuery<Record4<Int?, String?, Int?, String?>> = sqlBuilder.genSqlGameByGenre(limit)

        // Retrieve sql with named parameter
        val sql = selectQuery.getSQL(ParamType.NAMED)
        logger.info(sql)
        // and create actual hibernate query
        val query = jpaEntityManager.createNativeQuery(sql, "GameAndGenreMapping")
        // fill in parameter
        selectQuery.params.forEach { (n: String?, v: Param<*>) ->
            query.setParameter(
                n,
                v.value
            )
        }
        // execute query
        return query.resultList as MutableList<GameAndGenreDTO>
    }

    /**
     * We go direct via JOOQ and fetch and transform the result to JSON. Used for REST.
     */
    fun getTopSellersByPlatformJSON(limit: Int?): Any {
        val selectQuery: SelectQuery<Record6<String?, String?, String?, Int?, String?, BigDecimal>> =
            sqlBuilder.genSqlTopSellersByRegion(limit)
        val sql = selectQuery.getSQL(ParamType.NAMED)
        logger.info(sql)
        return selectQuery.fetch().formatJSON()
    }

    /**
     * We use the JPA SqlResultSetMapping to map the result to a dto (TopSellersByPlatformDTO). Used for Web.
     */
    fun getTopSellersByPlatformWeb(limit: Int?): MutableList<TopSellersByPlatformDTO>? {
        val selectQuery: SelectQuery<Record6<String?, String?, String?, Int?, String?, BigDecimal>> =
            sqlBuilder.genSqlTopSellersByRegion(limit)
        val sql = selectQuery.getSQL(ParamType.NAMED)
        logger.info(sql)
        // and create actual hibernate query
        val query = jpaEntityManager.createNativeQuery(sql, "TopSellersByRegion")
        // fill in parameter
        selectQuery.params.forEach { (n: String?, v: Param<*>) ->
            query.setParameter(
                n,
                v.value
            )
        }
        // execute query
        return query.resultList as MutableList<TopSellersByPlatformDTO>
    }

}
