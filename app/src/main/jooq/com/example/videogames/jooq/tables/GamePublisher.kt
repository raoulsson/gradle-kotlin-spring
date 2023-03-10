/*
 * This file is generated by jOOQ.
 */
package com.example.videogames.jooq.tables


import com.example.videogames.jooq.VideoGames
import com.example.videogames.jooq.keys.FK_GPU_GAM
import com.example.videogames.jooq.keys.FK_GPU_PUB
import com.example.videogames.jooq.keys.KEY_GAME_PUBLISHER_PRIMARY
import com.example.videogames.jooq.tables.records.GamePublisherRecord

import java.util.function.Function

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row3
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class GamePublisher(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, GamePublisherRecord>?,
    aliased: Table<GamePublisherRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<GamePublisherRecord>(
    alias,
    VideoGames.VIDEO_GAMES,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>video_games.game_publisher</code>
         */
        val GAME_PUBLISHER: GamePublisher = GamePublisher()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<GamePublisherRecord> = GamePublisherRecord::class.java

    /**
     * The column <code>video_games.game_publisher.id</code>.
     */
    val ID: TableField<GamePublisherRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>video_games.game_publisher.game_id</code>.
     */
    val GAME_ID: TableField<GamePublisherRecord, Int?> = createField(DSL.name("game_id"), SQLDataType.INTEGER.defaultValue(DSL.inline("NULL", SQLDataType.INTEGER)), this, "")

    /**
     * The column <code>video_games.game_publisher.publisher_id</code>.
     */
    val PUBLISHER_ID: TableField<GamePublisherRecord, Int?> = createField(DSL.name("publisher_id"), SQLDataType.INTEGER.defaultValue(DSL.inline("NULL", SQLDataType.INTEGER)), this, "")

    private constructor(alias: Name, aliased: Table<GamePublisherRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<GamePublisherRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>video_games.game_publisher</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>video_games.game_publisher</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>video_games.game_publisher</code> table reference
     */
    constructor(): this(DSL.name("game_publisher"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, GamePublisherRecord>): this(Internal.createPathAlias(child, key), child, key, GAME_PUBLISHER, null)
    override fun getSchema(): Schema? = if (aliased()) null else VideoGames.VIDEO_GAMES
    override fun getIdentity(): Identity<GamePublisherRecord, Int?> = super.getIdentity() as Identity<GamePublisherRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<GamePublisherRecord> = KEY_GAME_PUBLISHER_PRIMARY
    override fun getReferences(): List<ForeignKey<GamePublisherRecord, *>> = listOf(FK_GPU_GAM, FK_GPU_PUB)

    private lateinit var _game: Game
    private lateinit var _publisher: Publisher

    /**
     * Get the implicit join path to the <code>video_games.game</code> table.
     */
    fun game(): Game {
        if (!this::_game.isInitialized)
            _game = Game(this, FK_GPU_GAM)

        return _game;
    }

    val game: Game
        get(): Game = game()

    /**
     * Get the implicit join path to the <code>video_games.publisher</code>
     * table.
     */
    fun publisher(): Publisher {
        if (!this::_publisher.isInitialized)
            _publisher = Publisher(this, FK_GPU_PUB)

        return _publisher;
    }

    val publisher: Publisher
        get(): Publisher = publisher()
    override fun `as`(alias: String): GamePublisher = GamePublisher(DSL.name(alias), this)
    override fun `as`(alias: Name): GamePublisher = GamePublisher(alias, this)
    override fun `as`(alias: Table<*>): GamePublisher = GamePublisher(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): GamePublisher = GamePublisher(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): GamePublisher = GamePublisher(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): GamePublisher = GamePublisher(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row3<Int?, Int?, Int?> = super.fieldsRow() as Row3<Int?, Int?, Int?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (Int?, Int?, Int?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (Int?, Int?, Int?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
