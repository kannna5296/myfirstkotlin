package com.example.myfirstkotlin.controller

import com.example.myfirstkotlin.request.CreateDiaryRequest
import com.example.myfirstkotlin.request.UpdateDiaryRequest
import com.example.myfirstkotlin.response.CreateDiaryResponse
import com.example.myfirstkotlin.response.EmptyResponse
import com.example.myfirstkotlin.response.GetDiaryListResponse
import com.example.myfirstkotlin.response.UpdateDiaryResponse
import com.example.myfirstkotlin.service.DiaryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DiaryController(private val diaryService: DiaryService) {

    // TODO ページング
    @GetMapping("diary")
    fun getDiaryList(): ResponseEntity<GetDiaryListResponse> {
        return ResponseEntity.ok(GetDiaryListResponse(diaryService.getDiaryList()))
    }

    @PostMapping("diary")
    fun createDiary(req: CreateDiaryRequest): ResponseEntity<CreateDiaryResponse> {
        return ResponseEntity.ok(CreateDiaryResponse(diaryService.create(req)))
    }

    @PutMapping("diary")
    fun updateDiary(req: UpdateDiaryRequest): ResponseEntity<UpdateDiaryResponse> {
        return ResponseEntity.ok(UpdateDiaryResponse(diaryService.update(req)))
    }

    @DeleteMapping("diary/{id}")
    fun deleteDiary(@PathVariable id: Int): ResponseEntity<EmptyResponse> {
        diaryService.delete(id)
        return ResponseEntity.ok(EmptyResponse())
    }
}
