package com.example.myfirstkotlin

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface DiaryRepository : JpaRepository<Diary, Int> {

}