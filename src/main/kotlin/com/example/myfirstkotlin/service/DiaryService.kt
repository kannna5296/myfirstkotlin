package com.example.myfirstkotlin.service

import com.example.myfirstkotlin.entity.Diary
import com.example.myfirstkotlin.request.CreateDiaryRequest
import com.example.myfirstkotlin.request.UpdateDiaryRequest

interface DiaryService {

    fun getDiaryList(): List<Diary>

    fun create(req: CreateDiaryRequest): Diary

    fun update(req: UpdateDiaryRequest): Diary
}
