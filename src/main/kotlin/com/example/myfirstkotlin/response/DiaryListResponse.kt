package com.example.myfirstkotlin.response

import com.example.myfirstkotlin.entity.Diary

data class DiaryListResponse(
    val diaries: List<Diary>)
