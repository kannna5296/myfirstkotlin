package com.example.myfirstkotlin

import org.joda.time.DateTime

data class Diary(val id: Int,
                 val authorName: String,
                 val content: String,
                 val createdAt: DateTime)