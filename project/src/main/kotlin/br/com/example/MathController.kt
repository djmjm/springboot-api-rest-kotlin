package br.com.example

import br.com.example.exceptions.ExceptionResponse
import br.com.example.exceptions.UnsuportedMathOperationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.lang.Exception
import java.util.*
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

    ): Double{
        try {
            return (converToDouble(numberOne)
                    +
                    converToDouble(numberTwo)
                    )
        }
        catch(ex : UnsuportedMathOperationException){
            throw ex;
        }

    }

    private fun converToDouble(strNumber: String?) : Double {
        if(strNumber.isNullOrBlank())
            throw UnsuportedMathOperationException("Por favor, coloque um valor numérico")
        if(isNumeric(strNumber))
            throw UnsuportedMathOperationException("Por favor, coloque um valor numérico")

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