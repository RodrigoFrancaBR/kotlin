package br.com.franca.restwithspringbootandkotlin.helper

import org.springframework.data.domain.Page

object PageHelper : AbstractHelper() {

    fun getDefaultPage(): Page<*> {
        val string = getDefaultPageString()
        return getPage(string)
    }

    private fun getDefaultPageString() =
        """{"pageNumber":0,"pageSize":10,"sort":{"empty":false,"unsorted":false,"sorted":true},"offset":0,"paged":true,"unpaged":false}"""

    private fun getPage(string: String): Page<*> {
        val messageError = "Error writeStringAsObject someString: $string someClass: ${Page::class.java}"
        return writeStringAsObjectOrElseThrow(string, Page::class.java, messageError) as Page<*>
    }
}