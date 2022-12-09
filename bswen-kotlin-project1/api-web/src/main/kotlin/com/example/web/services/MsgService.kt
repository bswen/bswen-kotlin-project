package com.example.web.services

import com.example.domain.Message
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class MsgService {
    fun getMsgs():List<Message> {
        val mapper = ObjectMapper()
        val msgstr:String? =
            RestTemplate().getForObject("http://localhost:8081/msg/", String::class.java)
        return mapper.readValue(msgstr, object : TypeReference<List<Message>>() {})
    }
}