/*
 * This file is generated by jOOQ.
 */
package com.example.videogames.jooq.tables.records


import com.example.videogames.jooq.tables.GamePublisher

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record3
import org.jooq.Row3
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class GamePublisherRecord() : UpdatableRecordImpl<GamePublisherRecord>(GamePublisher.GAME_PUBLISHER), Record3<Int?, Int?, Int?> {

    open var id: Int?
        set(value): Unit = set(0, value)
        get(): Int? = get(0) as Int?

    open var gameId: Int?
        set(value): Unit = set(1, value)
        get(): Int? = get(1) as Int?

    open var publisherId: Int?
        set(value): Unit = set(2, value)
        get(): Int? = get(2) as Int?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row3<Int?, Int?, Int?> = super.fieldsRow() as Row3<Int?, Int?, Int?>
    override fun valuesRow(): Row3<Int?, Int?, Int?> = super.valuesRow() as Row3<Int?, Int?, Int?>
    override fun field1(): Field<Int?> = GamePublisher.GAME_PUBLISHER.ID
    override fun field2(): Field<Int?> = GamePublisher.GAME_PUBLISHER.GAME_ID
    override fun field3(): Field<Int?> = GamePublisher.GAME_PUBLISHER.PUBLISHER_ID
    override fun component1(): Int? = id
    override fun component2(): Int? = gameId
    override fun component3(): Int? = publisherId
    override fun value1(): Int? = id
    override fun value2(): Int? = gameId
    override fun value3(): Int? = publisherId

    override fun value1(value: Int?): GamePublisherRecord {
        this.id = value
        return this
    }

    override fun value2(value: Int?): GamePublisherRecord {
        this.gameId = value
        return this
    }

    override fun value3(value: Int?): GamePublisherRecord {
        this.publisherId = value
        return this
    }

    override fun values(value1: Int?, value2: Int?, value3: Int?): GamePublisherRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        return this
    }

    /**
     * Create a detached, initialised GamePublisherRecord
     */
    constructor(id: Int? = null, gameId: Int? = null, publisherId: Int? = null): this() {
        this.id = id
        this.gameId = gameId
        this.publisherId = publisherId
    }
}
