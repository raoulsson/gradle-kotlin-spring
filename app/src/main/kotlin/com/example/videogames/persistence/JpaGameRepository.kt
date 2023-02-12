package com.example.videogames.persistence

import org.springframework.data.domain.Sort
import org.springframework.data.repository.PagingAndSortingRepository

interface JpaGameRepository : PagingAndSortingRepository<GameEntity, Long> {
    override fun findAll(sort: Sort): Iterable<GameEntity>
    fun getById(id: Long): GameEntity?

    fun save(gameEntity: GameEntity): GameEntity
}