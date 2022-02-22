package com.example.myfirstkotlin.service.impl

import com.example.myfirstkotlin.entity.Diary
import com.example.myfirstkotlin.exception.NotFoundException
import com.example.myfirstkotlin.repository.IDiaryRepository
import com.example.myfirstkotlin.request.CreateDiaryRequest
import com.example.myfirstkotlin.request.UpdateDiaryRequest
import com.example.myfirstkotlin.service.DiaryService
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class DiaryServiceImpl(private val IDiaryRepository: IDiaryRepository) : DiaryService {

    override fun getDiaryList(): List<Diary> {
        return IDiaryRepository.findAll()
    }

    override fun create(req: CreateDiaryRequest): Diary {
        var diary = Diary(req.authorName, req.content)
        diary.createdAt = Timestamp(System.currentTimeMillis())
        diary.updatedAt = Timestamp(System.currentTimeMillis())
        IDiaryRepository.save(diary)
        return diary
    }

    override fun update(req: UpdateDiaryRequest): Diary {
        //論理チェック
        var diary = IDiaryRepository.findById(req.id).orElseThrow { NotFoundException("指定した投稿は存在しません。") }
        diary.content = req.content
        diary.updatedAt = Timestamp(System.currentTimeMillis())
        IDiaryRepository.save(diary)
        return diary
    }

    override fun delete(id: Int) {
        //論理チェック
        IDiaryRepository.findById(id).orElseThrow { NotFoundException("指定した投稿は存在しません。") }
        IDiaryRepository.deleteById(id)
    }
}
