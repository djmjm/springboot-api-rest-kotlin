package br.com.example.exceptions

import java.lang.Exception

class UnsuportedMathOperationException ( exception: String? ):
    RuntimeException(exception)