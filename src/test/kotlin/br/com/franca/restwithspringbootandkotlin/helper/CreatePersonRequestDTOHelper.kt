package br.com.franca.restwithspringbootandkotlin.helper

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.CreatePersonRequestDTO

object CreatePersonRequestDTOHelper : AbstractHelper() {
    fun getDefaultCreatePersonRequestDTO(): CreatePersonRequestDTO {
        val string = getDefaultPersonString()
        return getCreatePersonRequestDTO(string)
    }

    private fun getDefaultPersonString() =
        """{
    "firstName": "Default first name",
    "lastName": "Default last name",
    "address": "Default address",
    "gender": "Male"
    }"""


    private fun getCreatePersonRequestDTO(string: String): CreatePersonRequestDTO {
        val messageError =
            "Error writeStringAsObject someString: $string someClass: ${CreatePersonRequestDTO::class.java}"
        return writeStringAsObjectOrElseThrow(
            string,
            CreatePersonRequestDTO::class.java,
            messageError
        ) as CreatePersonRequestDTO
    }

    fun getCreatePersonRequestDTOList(elements: Int): List<CreatePersonRequestDTO> {
        val persons = ArrayList<CreatePersonRequestDTO>()
        for (i in 1..elements) {
            val string = getCustomizePersonString(i);
            persons.add(getCreatePersonRequestDTO(string))
        }
        return persons;
    }

    private fun getCustomizePersonString(number: Int): String {
        return """{
    "firstName": "First name_$number",
    "lastName": "Last name_$number",
    "address": "Address_$number",
    "gender": "Male"
    }"""
    }
}