package br.com.franca.restwithspringbootandkotlin.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {
    val counter: AtomicLong = AtomicLong();

    @RequestMapping("/sum/{number-one}/{number-two}")
    fun sum(
        @PathVariable(value = "number-one") numberOne: String?,
        @PathVariable(value = "number-two") numberTwo: String?
    ): Double {
        return 1.0
    }
}