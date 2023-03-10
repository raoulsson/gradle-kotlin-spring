/*
 * This file is generated by jOOQ.
 */
package com.example.videogames.jooq.tables.records


import com.example.videogames.jooq.tables.GamePlatform

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record4
import org.jooq.Row4
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class GamePlatformRecord() : UpdatableRecordImpl<GamePlatformRecord>(GamePlatform.GAME_PLATFORM), Record4<Int?, Int?, Int?, Int?> {

    open var id: Int?
        set(value): Unit = set(0, value)
        get(): Int? = get(0) as Int?

    open var gamePublisherId: Int?
        set(value): Unit = set(1, value)
        get(): Int? = get(1) as Int?

    open var platformId: Int?
        set(value): Unit = set(2, value)
        get(): Int? = get(2) as Int?

    open var releaseYear: Int?
        set(value): Unit = set(3, value)
        get(): Int? = get(3) as Int?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row4<Int?, Int?, Int?, Int?> = super.fieldsRow() as Row4<Int?, Int?, Int?, Int?>
    override fun valuesRow(): Row4<Int?, Int?, Int?, Int?> = super.valuesRow() as Row4<Int?, Int?, Int?, Int?>
    override fun field1(): Field<Int?> = GamePlatform.GAME_PLATFORM.ID
    override fun field2(): Field<Int?> = GamePlatform.GAME_PLATFORM.GAME_PUBLISHER_ID
    override fun field3(): Field<Int?> = GamePlatform.GAME_PLATFORM.PLATFORM_ID
    override fun field4(): Field<Int?> = GamePlatform.GAME_PLATFORM.RELEASE_YEAR
    override fun component1(): Int? = id
    override fun component2(): Int? = gamePublisherId
    override fun component3(): Int? = platformId
    override fun component4(): Int? = releaseYear
    override fun value1(): Int? = id
    override fun value2(): Int? = gamePublisherId
    override fun value3(): Int? = platformId
    override fun value4(): Int? = releaseYear

    override fun value1(value: Int?): GamePlatformRecord {
        this.id = value
        return this
    }

    override fun value2(value: Int?): GamePlatformRecord {
        this.gamePublisherId = value
        return this
    }

    override fun value3(value: Int?): GamePlatformRecord {
        this.platformId = value
        return this
    }

    override fun value4(value: Int?): GamePlatformRecord {
        this.releaseYear = value
        return this
    }

    override fun values(value1: Int?, value2: Int?, value3: Int?, value4: Int?): GamePlatformRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        return this
    }

    /**
     * Create a detached, initialised GamePlatformRecord
     */
    constructor(id: Int? = null, gamePublisherId: Int? = null, platformId: Int? = null, releaseYear: Int? = null): this() {
        this.id = id
        this.gamePublisherId = gamePublisherId
        this.platformId = platformId
        this.releaseYear = releaseYear
    }
}
