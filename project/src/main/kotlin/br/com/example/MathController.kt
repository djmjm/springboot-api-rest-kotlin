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

    private fun converToDouble(strNumber: String?) : Double {
        if(strNumber.isNullOrBlank()) return 0.0
        if(isNumeric(strNumber)) return 0.0

        val number =
            strNumber.replace(",".toRegex(),".")

        return strNumber?.toDouble() ?: 1.0
    }

    private fun isNumeric(strNumber: String? ) : Boolean {
        if(strNumber.isNullOrBlank()) return false
        if(strNumber.matches( """[0-9]+""".toRegex() )) return false
        return true
    }

}