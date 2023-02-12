package com.example.videogames.persistence

import jakarta.persistence.*

@Entity
@SequenceGenerator(name = "game_seq", allocationSize = 1)
@Table(name = "game")
data class GameEntity(
    @Column(name = "game_name")
    var gameName: String,
    @ManyToOne var genre: GenreEntity,
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq") var id: Long? = null
)