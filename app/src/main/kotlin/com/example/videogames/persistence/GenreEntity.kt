package com.example.videogames.persistence

import jakarta.persistence.*

@Entity
@SequenceGenerator(name = "genre_seq", allocationSize = 1)
@Table(name = "genre")
data class GenreEntity(
    @Column(name = "genre_name")
    var genreName: String,
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq") var id: Long? = null
)