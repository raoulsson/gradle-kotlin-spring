/*
 * This file is generated by jOOQ.
 */
package com.example.videogames.jooq.tables


import com.example.videogames.jooq.VideoGames
import com.example.videogames.jooq.keys.KEY_GENRE_PRIMARY
import com.example.videogames.jooq.tables.records.GenreRecord

import java.util.function.Function

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row2
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
open class Genre(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, GenreRecord>?,
    aliased: Table<GenreRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<GenreRecord>(
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
         * The reference instance of <code>video_games.genre</code>
         */
        val GENRE: Genre = Genre()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<GenreRecord> = GenreRecord::class.java

    /**
     * The column <code>video_games.genre.id</code>.
     */
    val ID: TableField<GenreRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>video_games.genre.genre_name</code>.
     */
    val GENRE_NAME: TableField<GenreRecord, String?> = createField(DSL.name("genre_name"), SQLDataType.VARCHAR(50).defaultValue(DSL.inline("NULL", SQLDataType.VARCHAR)), this, "")

    private constructor(alias: Name, aliased: Table<GenreRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<GenreRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>video_games.genre</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>video_games.genre</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>video_games.genre</code> table reference
     */
    constructor(): this(DSL.name("genre"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, GenreRecord>): this(Internal.createPathAlias(child, key), child, key, GENRE, null)
    override fun getSchema(): Schema? = if (aliased()) null else VideoGames.VIDEO_GAMES
    override fun getIdentity(): Identity<GenreRecord, Int?> = super.getIdentity() as Identity<GenreRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<GenreRecord> = KEY_GENRE_PRIMARY
    override fun `as`(alias: String): Genre = Genre(DSL.name(alias), this)
    override fun `as`(alias: Name): Genre = Genre(alias, this)
    override fun `as`(alias: Table<*>): Genre = Genre(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Genre = Genre(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Genre = Genre(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Genre = Genre(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row2<Int?, String?> = super.fieldsRow() as Row2<Int?, String?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (Int?, String?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (Int?, String?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
