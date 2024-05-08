package br.com.franca.restwithspringbootandkotlin.helper

import br.com.franca.restwithspringbootandkotlin.service.PersonService
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.util.*
import java.util.logging.Logger


object ObjectMapperHelper {

    private val log = Logger.getLogger(PersonService::class.java.name)
    private val mapper: ObjectMapper = getMapper();

    private fun getMapper(): ObjectMapper {
        return ObjectMapper()
            .registerKotlinModule()
    }

    fun writeStringAsObject(someString: String?, someClass: Class<*>?): Optional<Any>? {
        return try {
            val someObject = mapper.readValue(someString, someClass)
            Optional.of(someObject)
        } catch (ex: JsonProcessingException) {
            log.warning("Error writeStringAsObject someString: $someClass someClass: $someClass error: $ex")
            Optional.empty()
        }
    }

    fun writeObjectAsString(someObject: Any?): Optional<Any>? {
        return try {
            val json = mapper.writeValueAsString(someObject)
            Optional.of(json)
        } catch (ex: JsonProcessingException) {
            log.warning("Error writeObjectAsString someObject: $someObject error: $ex")
            Optional.empty()
        }
    }
}