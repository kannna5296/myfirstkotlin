package com.example.myfirstkotlin

import lombok.Getter
import lombok.Setter
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Getter
@Setter
@Table(name = "diary")
data class Diary(
    @Id
    @GeneratedValue
    var id: Int,
    var authorName: String,
    var content: String,
    var createdAt: Timestamp,
    var updatedAt: Timestamp)