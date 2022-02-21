package com.example.myfirstkotlin.service.impl

import com.example.myfirstkotlin.entity.Diary
import com.example.myfirstkotlin.repository.DiaryRepository
import com.example.myfirstkotlin.service.DiaryService
import org.springframework.stereotype.Service

@Service
class DiaryServiceImpl(private val diaryRepository: DiaryRepository) : DiaryService {

    override fun getDiaryList() :List<Diary>{
        return diaryRepository.findAll();
    }

}