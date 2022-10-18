package br.com.example

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable (value="numberOne")
        numberOne : String?,
        @PathVariable (value="numberTwo")
        numberTwo : String?,

    ): Double {
        return (converToDouble( numberOne )
               +
               converToDouble( numberTwo )
                )

    }

    fun converToDouble(number: String?) : Double {
        return number?.toDouble() ?: 1.0
    }

}