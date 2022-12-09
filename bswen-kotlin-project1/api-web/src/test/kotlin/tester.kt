import com.example.domain.Message
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import java.util.*
import java.util.stream.Collectors

/**
 * example code of this post: https://www.bswen.com/2022/11/kotlin1.html
 */

class tester {
}

fun main() {
    //test_will_error()
    test_success_3()
}

fun test_will_error() {
    val msgs:List<Message>? =
        RestTemplate().getForObject("http://localhost:8081/msg/", List::class.java) as List<Message>
    if(msgs!=null) {
        println("got ${msgs.size} messages as follows:")
        for (msg in msgs) {
            println(msg)
        }
    }
}

fun test_success_3() {
    val responseEntity: ResponseEntity<List<Message>> = RestTemplate().exchange(
        "http://localhost:8081/msg/",
        HttpMethod.GET,
        null,
        object : ParameterizedTypeReference<List<Message>>() {}
    )
    val msgs: List<Message>? = responseEntity.body
    if(msgs!=null) {
        println("got ${msgs.size} messages as follows:")
        for (msg in msgs) {
            println(msg)
        }
    }
}

fun test_success_2() {
    val responseEntity: ResponseEntity<Array<Message>> = RestTemplate().getForEntity("http://localhost:8081/msg/",
        Array<Message>::class.java)
    val msgsArray: Array<Message> = responseEntity.body!!
    val msgs: List<Message> =  Arrays.stream(msgsArray)
        .collect(Collectors.toList())
    if(msgs!=null) {
        println("got ${msgs.size} messages as follows:")
        for (msg in msgs) {
            println(msg)
        }
    }
}

fun test_success_1() {
    val mapper = ObjectMapper()
    val msgstr:String? =
        RestTemplate().getForObject("http://localhost:8081/msg/", String::class.java)
    val msgs: List<Message> = mapper.readValue(msgstr, object : TypeReference<List<Message>>() {})
    if(msgs!=null) {
        println("got ${msgs.size} messages as follows:")
        for (msg in msgs) {
            println(msg)
        }
    }
}