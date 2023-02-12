package com.example.videogames.dto

import jakarta.persistence.*

/**
 * "The @SqlResultSetMapping and @NamedNativeQuery annotations need to be on an @Entity, not on the non-entity POJO."
 * https://stackoverflow.com/a/49536120/132396
 */
@Entity
@SqlResultSetMapping(
    name = "GameAndGenreMapping", classes = (arrayOf(
        ConstructorResult(
            targetClass = GameAndGenreDTO::class,
            columns = (
                    arrayOf(
                        ColumnResult(name = "game_id", type = Long::class),
                        ColumnResult(name = "game_name"),
                        ColumnResult(name = "genre_id", type = Long::class),
                        ColumnResult(name = "genre_name")
                    ))
        )
    ))
)
@SqlResultSetMapping(
    name = "TopSellersByRegion", classes = (arrayOf(
        ConstructorResult(
            targetClass = TopSellersByPlatformDTO::class,
            columns = (
                    arrayOf(
                        ColumnResult(name = "game_name"),
                        ColumnResult(name = "genre_name"),
                        ColumnResult(name = "platform_name"),
                        ColumnResult(name = "release_year", type = Int::class),
                        ColumnResult(name = "publisher_name"),
                        ColumnResult(name = "global_sales", type = Double::class),
                    ))
        )
    ))
)
class DummyEntity() {
    @Id
    var id: Long? = null
}

data class GameAndGenreDTO(val gameId: Long, val gameName: String, val genreId: Long, val genreName: String)

data class TopSellersByPlatformDTO(
    val gameName: String,
    val genreName: String,
    val platformName: String,
    val releaseYear: Int,
    val publisherName: String,
    val globalSales: Double
)
