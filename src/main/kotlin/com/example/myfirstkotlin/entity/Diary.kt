package com.example.myfirstkotlin.entity

import lombok.Getter
import lombok.Setter
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Size

@Entity
@Getter
@Setter
@Table(name = "diary")
class Diary(
    @Id
    @GeneratedValue
    var id: Int?,
    @Size(max = 50)
    var authorName: String,
    @Size(max = 140)
    var content: String,
    var createdAt: Timestamp?,
    var updatedAt: Timestamp?) {

//    constructor(authorName: String, content: String) : this(authorName, content, null, ) {
//
//    }
}