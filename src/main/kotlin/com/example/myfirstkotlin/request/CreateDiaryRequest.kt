package com.example.myfirstkotlin.request

import javax.validation.constraints.Size

data class CreateDiaryRequest(
    @Size(max = 50)
    var authorName: String,
    @Size(max = 140)
    var content: String)