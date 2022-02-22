package com.example.myfirstkotlin.entity

import lombok.Getter
import lombok.Setter
import java.sql.Timestamp
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "diary")
class Diary(
    var authorName: String,
    var content: String) {

    var createdAt: Timestamp? = null
    var updatedAt: Timestamp? = null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
}