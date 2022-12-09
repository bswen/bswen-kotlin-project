package com.example.web.controllers

import com.example.domain.Message
import com.example.web.services.MsgService
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.client.RestTemplate
import java.util.*

@Controller
class HtmlController {

    @Autowired
    lateinit var msgService: MsgService

    @GetMapping("/")
    fun blog(model: Model):String {
        model["title"] = "zzz blog"
        return "blog"
    }

    @GetMapping("/messages")
    fun blogMsg(model: Model):String {
        model["title"] = "Messages List"
        model["date"] = Date()
        val msgs: List<Message> = msgService.getMsgs()
        if(msgs!=null) {
            println("got ${msgs.size} messages as follows:$msgs")
            model["msgs"] = msgs
        }
        return "msgs"
    }
}