package com.example.myfirstkotlin

import org.springframework.stereotype.Service

@Service
class DiaryServiceImpl(private val diaryRepository: DiaryRepository) : DiaryService{

    override fun getDiaryList() :List<Diary>{
        return diaryRepository.findAll();
    }

}