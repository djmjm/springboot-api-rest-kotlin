package br.com.example.exceptions


import java.sql.Timestamp
import java.util.Date

class ExceptionResponse (
            val timestamp: Date,
            val message: String?,
            val details: String
        )