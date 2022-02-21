package com.example.myfirstkotlin.service.impl

import com.example.myfirstkotlin.entity.Diary
import com.example.myfirstkotlin.repository.DiaryRepository
import com.example.myfirstkotlin.request.CreateDiaryRequest
import com.example.myfirstkotlin.service.DiaryService
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class DiaryServiceImpl(private val diaryRepository: DiaryRepository) : DiaryService {

    override fun getDiaryList() :List<Diary>{
        return diaryRepository.findAll();
    }

    override fun create(req: CreateDiaryRequest): Diary {
        var diary = Diary(null,req.authorName,req.content,null,null)
        diary.createdAt = Timestamp(System.currentTimeMillis())
        diary.updatedAt = Timestamp(System.currentTimeMillis())
        diaryRepository.save(diary)
        return diary
    }

}