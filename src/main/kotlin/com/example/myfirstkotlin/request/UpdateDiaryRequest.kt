package com.example.myfirstkotlin.request

import javax.validation.constraints.Size

data class UpdateDiaryRequest(
    @Size(max = 140)
    var content: String,
    var id: Int)