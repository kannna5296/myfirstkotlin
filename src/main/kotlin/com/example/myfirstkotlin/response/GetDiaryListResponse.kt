package com.example.myfirstkotlin.response

import com.example.myfirstkotlin.entity.Diary

data class GetDiaryListResponse(
    val diaries: List<Diary>)
