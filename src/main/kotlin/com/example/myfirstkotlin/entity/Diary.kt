package com.example.myfirstkotlin.entity

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "diary")
class Diary(
    var authorName: String,
    var content: String
) {

    var createdAt: Timestamp? = null
    var updatedAt: Timestamp? = null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
}
