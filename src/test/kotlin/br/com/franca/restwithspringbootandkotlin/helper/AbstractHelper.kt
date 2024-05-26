package br.com.franca.restwithspringbootandkotlin.helper

import br.com.franca.restwithspringbootandkotlin.model.Person

typealias Mapper = ObjectMapperHelper

abstract class AbstractHelper {

    fun writeStringAsObjectOrElseThrow(
        someString: String?,
        someClass: Class<*>?,
        messageError: String,
    ): Any {
        return Mapper.writeStringAsObject(someString, someClass)
            ?.orElseThrow { IllegalArgumentException(messageError) } as Any
    }

    fun writeStringAsObjectOrElse(
        someString: String?,
        someClass: Class<*>?,
        messageError: String,
    ): Any {
        return Mapper.writeStringAsObject(someString, someClass)
            ?.orElse(messageError) as Any
    }
}