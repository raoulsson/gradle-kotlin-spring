/*
 * This file is generated by jOOQ.
 */
package com.example.videogames.jooq.tables.records


import com.example.videogames.jooq.tables.RegionSales

import java.math.BigDecimal

import org.jooq.Field
import org.jooq.Record3
import org.jooq.Row3
import org.jooq.impl.TableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class RegionSalesRecord() : TableRecordImpl<RegionSalesRecord>(RegionSales.REGION_SALES), Record3<Int?, Int?, BigDecimal?> {

    open var regionId: Int?
        set(value): Unit = set(0, value)
        get(): Int? = get(0) as Int?

    open var gamePlatformId: Int?
        set(value): Unit = set(1, value)
        get(): Int? = get(1) as Int?

    open var numSales: BigDecimal?
        set(value): Unit = set(2, value)
        get(): BigDecimal? = get(2) as BigDecimal?

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row3<Int?, Int?, BigDecimal?> = super.fieldsRow() as Row3<Int?, Int?, BigDecimal?>
    override fun valuesRow(): Row3<Int?, Int?, BigDecimal?> = super.valuesRow() as Row3<Int?, Int?, BigDecimal?>
    override fun field1(): Field<Int?> = RegionSales.REGION_SALES.REGION_ID
    override fun field2(): Field<Int?> = RegionSales.REGION_SALES.GAME_PLATFORM_ID
    override fun field3(): Field<BigDecimal?> = RegionSales.REGION_SALES.NUM_SALES
    override fun component1(): Int? = regionId
    override fun component2(): Int? = gamePlatformId
    override fun component3(): BigDecimal? = numSales
    override fun value1(): Int? = regionId
    override fun value2(): Int? = gamePlatformId
    override fun value3(): BigDecimal? = numSales

    override fun value1(value: Int?): RegionSalesRecord {
        this.regionId = value
        return this
    }

    override fun value2(value: Int?): RegionSalesRecord {
        this.gamePlatformId = value
        return this
    }

    override fun value3(value: BigDecimal?): RegionSalesRecord {
        this.numSales = value
        return this
    }

    override fun values(value1: Int?, value2: Int?, value3: BigDecimal?): RegionSalesRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        return this
    }

    /**
     * Create a detached, initialised RegionSalesRecord
     */
    constructor(regionId: Int? = null, gamePlatformId: Int? = null, numSales: BigDecimal? = null): this() {
        this.regionId = regionId
        this.gamePlatformId = gamePlatformId
        this.numSales = numSales
    }
}
