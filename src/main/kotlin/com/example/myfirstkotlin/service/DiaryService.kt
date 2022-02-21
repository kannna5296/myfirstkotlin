package com.example.myfirstkotlin.service

import com.example.myfirstkotlin.entity.Diary
import com.example.myfirstkotlin.request.CreateDiaryRequest

interface DiaryService {

    fun getDiaryList(): List<Diary>

    fun create(req: CreateDiaryRequest): Diary

}