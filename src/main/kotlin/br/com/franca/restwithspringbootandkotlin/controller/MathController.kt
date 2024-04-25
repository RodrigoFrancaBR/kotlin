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
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw Exception()
        return convertDouble(numberOne) + convertDouble(numberTwo)
    }

    private fun convertDouble(numberOne: String?): Double {
        return 0.0
    }

    private fun isNumeric(numberOne: String?): Boolean {
        return false;
    }
}