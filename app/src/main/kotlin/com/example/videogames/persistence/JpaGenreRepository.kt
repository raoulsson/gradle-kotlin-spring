package com.example.videogames.persistence

import org.springframework.data.domain.Sort
import org.springframework.data.repository.PagingAndSortingRepository

interface JpaGenreRepository : PagingAndSortingRepository<GenreEntity, Long> {
    override fun findAll(sort: Sort): Iterable<GenreEntity>
    fun getById(id: Long): GenreEntity?

}