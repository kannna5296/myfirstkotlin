package com.example.myfirstkotlin.controller

import com.example.myfirstkotlin.response.DiaryListResponse
import com.example.myfirstkotlin.service.DiaryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DiaryController(private val diaryService: DiaryService) {

    //TODO ページング
    @GetMapping("diary")
    fun getIdeaList(): ResponseEntity<DiaryListResponse> {
        return ResponseEntity.ok(DiaryListResponse(diaryService.getDiaryList()))
    }
}