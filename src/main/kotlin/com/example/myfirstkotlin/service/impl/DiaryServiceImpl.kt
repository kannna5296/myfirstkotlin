package com.example.myfirstkotlin.service.impl

import com.example.myfirstkotlin.entity.Diary
import com.example.myfirstkotlin.exception.NotFoundException
import com.example.myfirstkotlin.repository.DiaryRepository
import com.example.myfirstkotlin.request.CreateDiaryRequest
import com.example.myfirstkotlin.request.UpdateDiaryRequest
import com.example.myfirstkotlin.service.DiaryService
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class DiaryServiceImpl(private val diaryRepository: DiaryRepository) : DiaryService {

    override fun getDiaryList(): List<Diary> {
        return diaryRepository.findAll()
    }

    override fun create(req: CreateDiaryRequest): Diary {
        var diary = Diary(req.authorName, req.content)
        diary.createdAt = Timestamp(System.currentTimeMillis())
        diary.updatedAt = Timestamp(System.currentTimeMillis())
        diaryRepository.save(diary)
        return diary
    }

    override fun update(req: UpdateDiaryRequest): Diary {
        var diary = diaryRepository.findById(req.id).orElseThrow { NotFoundException("投稿が見つかりません。") }
        diary.content = req.content
        diary.updatedAt = Timestamp(System.currentTimeMillis())
        diaryRepository.save(diary)
        return diary
    }

    override fun delete(id: Int) {
        diaryRepository.deleteById(id)
    }
}
