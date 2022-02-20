package com.example.myfirstkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DiaryController(private val diaryService: DiaryService) {

    @GetMapping("diary")
    fun getIdeaList(): List<Diary> {
        return diaryService.getDiaryList()
    }
}