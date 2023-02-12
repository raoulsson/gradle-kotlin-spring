package com.example.videogames.dao

import com.example.videogames.persistence.GameEntity
import com.example.videogames.persistence.GenreEntity
import com.example.videogames.persistence.JpaGameRepository
import com.example.videogames.persistence.JpaGenreRepository
import jakarta.persistence.EntityManager
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

@Component
class JpaDbAccessor(
    private val jpaEntityManager: EntityManager,
    private val jpaGameRepository: JpaGameRepository,
    private val jpaGenreRepository: JpaGenreRepository
) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun createGame(gameCreationParameters: GameCreationParameters) {
        val genre: GenreEntity? = jpaGenreRepository.getById(gameCreationParameters.genreId)
        val newGame = GameEntity(gameCreationParameters.gameName!!, genre!!)
        jpaGameRepository.save(newGame)
    }

    fun loadAllGenres(): List<GenreEntity> {
        val allGenres = jpaGenreRepository.findAll(Sort.by("genreName").ascending())
        return allGenres.iterator().asSequence().toList()
    }

}
