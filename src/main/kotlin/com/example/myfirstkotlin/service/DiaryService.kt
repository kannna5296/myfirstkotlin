package com.example.myfirstkotlin.service

import com.example.myfirstkotlin.entity.Diary

interface DiaryService {

    fun getDiaryList(): List<Diary>

}