package br.com.franca.restwithspringbootandkotlin.helper

abstract class AbstractHelper {

    fun writeStringAsObjectOrElseThrow(
        someString: String?,
        someClass: Class<*>?,
        messageError: String
    ): Any {
        return ObjectMapperHelper.writeStringAsObject(someString, someClass)
            ?.orElseThrow { IllegalArgumentException(messageError) } as Any
    }

    fun writeStringAsObjectOrElse(
        someString: String?,
        someClass: Class<*>?,
        messageError: String
    ): Any {
        return ObjectMapperHelper.writeStringAsObject(someString, someClass)
            ?.orElse(messageError) as Any
    }
}