package com.example.myfirstkotlin.controller

import com.example.myfirstkotlin.entity.Diary
import com.example.myfirstkotlin.service.DiaryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DiaryController(private val diaryService: DiaryService) {

    @GetMapping("diary")
    fun getIdeaList(): List<Diary> {
        return diaryService.getDiaryList()
    }
}