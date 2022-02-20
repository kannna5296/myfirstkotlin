package com.example.myfirstkotlin

import lombok.Getter
import lombok.Setter
import org.joda.time.DateTime
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
    var createdAt: DateTime)