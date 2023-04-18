package com.haejun.study.repository

import com.haejun.study.entity.Item
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ItemRepository : CoroutineCrudRepository<Item, Long>
