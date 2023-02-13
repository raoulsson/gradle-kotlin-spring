package com.example.videogames.service

import com.example.videogames.dao.GameCreationParameters
import com.example.videogames.dao.JooqDbAccessor
import com.example.videogames.dao.JpaDbAccessor
import com.example.videogames.dto.CreateGameFormData
import com.example.videogames.dto.GameAndGenreDTO
import com.example.videogames.dto.TopSellersByPlatformDTO
import com.example.videogames.persistence.GameEntity
import com.example.videogames.persistence.GenreEntity
import com.example.videogames.persistence.JpaGameRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class GameService(
    private val jooqDbAccessor: JooqDbAccessor,
    private val jpaDbAccessor: JpaDbAccessor,
    private val jpaGameRepository: JpaGameRepository
) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun findAllGames(): Iterable<GameEntity> {
        
        return jpaGameRepository.findAll(
            Sort.by("genre.genreName").ascending()
                .and(Sort.by("gameName").ascending())
        )
    }

    fun getGamesOrderByGenreName(limit: Int? = null): MutableList<GameAndGenreDTO>? {
        return jooqDbAccessor.getGamesOrderByGenreName(limit)
    }

    fun getTopSellersByPlatformWeb(limit: Int? = null): MutableList<TopSellersByPlatformDTO>? {
        return jooqDbAccessor.getTopSellersByPlatformWeb(limit)
    }

    fun prepareCreateGameFormData(): CreateGameFormData {
        val allGenres: List<GenreEntity> = jpaDbAccessor.loadAllGenres()
        val selectedGenreId: Long? = allGenres[0].id
        val selectedGenreName: String = allGenres[0].genreName
        val createGameFormData =
            CreateGameFormData(selectedGenreId = selectedGenreId, selectedGenreName = selectedGenreName)
        createGameFormData.allGenresDropDownData = allGenres
        return createGameFormData
    }

    fun createGame(gameCreationParameters: GameCreationParameters) {
        jpaDbAccessor.createGame(gameCreationParameters)
    }

}