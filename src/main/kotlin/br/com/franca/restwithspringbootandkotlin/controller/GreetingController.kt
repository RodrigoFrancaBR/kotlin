package br.com.franca.restwithspringbootandkotlin.controller

import br.com.franca.restwithspringbootandkotlin.domain.Greeting
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter: AtomicLong = AtomicLong();

    @RequestMapping("/greeting")
    fun greeting(): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello Kotlin")
    }

    @RequestMapping("/greeting-with-param")
    fun greetingWithParam(@RequestParam(value = "param-name", defaultValue = "World") param: String?) =
        Greeting(counter.incrementAndGet(), "Hello $param");


}