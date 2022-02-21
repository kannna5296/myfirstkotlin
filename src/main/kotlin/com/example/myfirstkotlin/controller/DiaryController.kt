package com.example.myfirstkotlin.controller

import com.example.myfirstkotlin.request.CreateDiaryRequest
import com.example.myfirstkotlin.response.GetDiaryListResponse
import com.example.myfirstkotlin.service.DiaryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DiaryController(private val diaryService: DiaryService) {

    //TODO ページング
    @GetMapping("diary")
    fun getDiaryList(): ResponseEntity<GetDiaryListResponse> {
        return ResponseEntity.ok(GetDiaryListResponse(diaryService.getDiaryList()))
    }

    @PutMapping("diary")
    fun createDiary(req: CreateDiaryRequest): ResponseEntity<CreateDiaryResponse> {
        return ResponseEntity.ok(CreateDiaryResponse(diaryService.create(req)))
    }
}