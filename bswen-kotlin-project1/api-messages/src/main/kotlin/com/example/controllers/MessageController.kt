package com.example.controllers

import com.example.domain.Message
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {

    @GetMapping
    fun index(): List<Message> {
        var result = listOf(
            Message("1","hello1"),
            Message("2","Object"),
            Message("3","Privot"),
        )
        return result
    }
}