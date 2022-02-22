package com.example.myfirstkotlin.repository

import com.example.myfirstkotlin.entity.Diary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

//TODO インターフェースがJpaに依存するのは辞めたい

@Repository
@Transactional
interface DiaryRepository : JpaRepository<Diary, Int>
