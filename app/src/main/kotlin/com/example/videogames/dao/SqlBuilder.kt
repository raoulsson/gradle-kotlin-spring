package com.example.videogames.dao

import org.jooq.DSLContext
import org.jooq.Record4
import org.jooq.Record6
import org.jooq.SelectQuery
import org.jooq.impl.DSL
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.math.BigDecimal
import com.example.videogames.jooq.tables.Game

(com.example.videogames.jooq.tables)

@Component
class SqlBuilder(private val dsl: DSLContext) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun genSqlGameByGenre(rowLimit: Int?): SelectQuery<Record4<Int?, String?, Int?, String?>> {
        val selectQuery = dsl.select(
            Game.GAME.ID.`as`("game_id"),
            Game.GAME.GAME_NAME.`as`("game_name"),
            GENRE.ID.`as`("genre_id"),
            GENRE.GENRE_NAME.`as`("genre_name")
        )
            .from(Game.GAME)
            .leftJoin(GENRE)
            .on(Game.GAME.GENRE_ID.eq(GENRE.ID))
            .orderBy(GENRE.GENRE_NAME, Game.GAME.GAME_NAME)
            .limit(rowLimit)
            .query
        return selectQuery
    }

    fun genSqlTopSellersByRegion(rowLimit: Int?): SelectQuery<Record6<String?, String?, String?, Int?, String?, BigDecimal>> {
        val selectQuery = dsl.select(
            Game.GAME.GAME_NAME.`as`("game_name"),
            GENRE.GENRE_NAME.`as`("genre_name"),
            PLATFORM.PLATFORM_NAME.`as`("platform_name"),
            GAME_PLATFORM.RELEASE_YEAR.`as`("release_year"),
            PUBLISHER.PUBLISHER_NAME.`as`("publisher_name"),
            DSL.sum(REGION_SALES.NUM_SALES).`as`("global_sales")
        ).from(REGION_SALES)
            .join(GAME_PLATFORM).onKey()
            .join(GAME_PUBLISHER).onKey()
            .join(Game.GAME).onKey()
            .join(GENRE).onKey()
            .join(PLATFORM).onKey()
            .join(PUBLISHER).onKey()
            .groupBy(Game.GAME.GAME_NAME, PLATFORM.PLATFORM_NAME, GAME_PLATFORM.RELEASE_YEAR, PUBLISHER.PUBLISHER_NAME)
            .orderBy(DSL.sum(REGION_SALES.NUM_SALES).desc())
            .limit(rowLimit)
            .query
        return selectQuery
    }
}