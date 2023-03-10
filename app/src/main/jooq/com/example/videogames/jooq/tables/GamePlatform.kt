/*
 * This file is generated by jOOQ.
 */
package com.example.videogames.jooq.tables


import com.example.videogames.jooq.VideoGames
import com.example.videogames.jooq.keys.FK_GPL_GP
import com.example.videogames.jooq.keys.FK_GPL_PLA
import com.example.videogames.jooq.keys.KEY_GAME_PLATFORM_PRIMARY
import com.example.videogames.jooq.tables.records.GamePlatformRecord

import java.util.function.Function

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row4
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
open class GamePlatform(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, GamePlatformRecord>?,
    aliased: Table<GamePlatformRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<GamePlatformRecord>(
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
         * The reference instance of <code>video_games.game_platform</code>
         */
        val GAME_PLATFORM: GamePlatform = GamePlatform()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<GamePlatformRecord> = GamePlatformRecord::class.java

    /**
     * The column <code>video_games.game_platform.id</code>.
     */
    val ID: TableField<GamePlatformRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>video_games.game_platform.game_publisher_id</code>.
     */
    val GAME_PUBLISHER_ID: TableField<GamePlatformRecord, Int?> = createField(DSL.name("game_publisher_id"), SQLDataType.INTEGER.defaultValue(DSL.inline("NULL", SQLDataType.INTEGER)), this, "")

    /**
     * The column <code>video_games.game_platform.platform_id</code>.
     */
    val PLATFORM_ID: TableField<GamePlatformRecord, Int?> = createField(DSL.name("platform_id"), SQLDataType.INTEGER.defaultValue(DSL.inline("NULL", SQLDataType.INTEGER)), this, "")

    /**
     * The column <code>video_games.game_platform.release_year</code>.
     */
    val RELEASE_YEAR: TableField<GamePlatformRecord, Int?> = createField(DSL.name("release_year"), SQLDataType.INTEGER.defaultValue(DSL.inline("NULL", SQLDataType.INTEGER)), this, "")

    private constructor(alias: Name, aliased: Table<GamePlatformRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<GamePlatformRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>video_games.game_platform</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>video_games.game_platform</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>video_games.game_platform</code> table reference
     */
    constructor(): this(DSL.name("game_platform"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, GamePlatformRecord>): this(Internal.createPathAlias(child, key), child, key, GAME_PLATFORM, null)
    override fun getSchema(): Schema? = if (aliased()) null else VideoGames.VIDEO_GAMES
    override fun getIdentity(): Identity<GamePlatformRecord, Int?> = super.getIdentity() as Identity<GamePlatformRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<GamePlatformRecord> = KEY_GAME_PLATFORM_PRIMARY
    override fun getReferences(): List<ForeignKey<GamePlatformRecord, *>> = listOf(FK_GPL_GP, FK_GPL_PLA)

    private lateinit var _gamePublisher: GamePublisher
    private lateinit var _platform: Platform

    /**
     * Get the implicit join path to the <code>video_games.game_publisher</code>
     * table.
     */
    fun gamePublisher(): GamePublisher {
        if (!this::_gamePublisher.isInitialized)
            _gamePublisher = GamePublisher(this, FK_GPL_GP)

        return _gamePublisher;
    }

    val gamePublisher: GamePublisher
        get(): GamePublisher = gamePublisher()

    /**
     * Get the implicit join path to the <code>video_games.platform</code>
     * table.
     */
    fun platform(): Platform {
        if (!this::_platform.isInitialized)
            _platform = Platform(this, FK_GPL_PLA)

        return _platform;
    }

    val platform: Platform
        get(): Platform = platform()
    override fun `as`(alias: String): GamePlatform = GamePlatform(DSL.name(alias), this)
    override fun `as`(alias: Name): GamePlatform = GamePlatform(alias, this)
    override fun `as`(alias: Table<*>): GamePlatform = GamePlatform(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): GamePlatform = GamePlatform(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): GamePlatform = GamePlatform(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): GamePlatform = GamePlatform(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row4<Int?, Int?, Int?, Int?> = super.fieldsRow() as Row4<Int?, Int?, Int?, Int?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (Int?, Int?, Int?, Int?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (Int?, Int?, Int?, Int?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
