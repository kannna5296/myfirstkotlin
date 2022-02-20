package com.example.myfirstkotlin

class DiaryServiceImpl(private val diaryRepository: DiaryRepository) : DiaryService{

    override fun getDiaryList() :List<Diary>{
        return diaryRepository.findAll();
    }

}