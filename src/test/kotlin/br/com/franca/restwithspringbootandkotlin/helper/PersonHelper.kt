package br.com.franca.restwithspringbootandkotlin.helper

import br.com.franca.restwithspringbootandkotlin.model.Person

object PersonHelper : AbstractHelper() {

    fun getDefaultPerson(): Person {
        val string = getDefaultPersonString()
        return getPerson(string)
    }

    private fun getDefaultPersonString() =
        """{
    "id": 0,
    "firstName": "Default first name",
    "lastName": "Default last name",
    "address": "Default address",
    "gender": "Male"
    }"""


    private fun getPerson(string: String): Person {
        val messageError = "Error writeStringAsObject someString: $string someClass: ${Person::class.java}"
        return writeStringAsObjectOrElseThrow(string, Person::class.java, messageError) as Person
    }

    fun getPersonList(elements: Int): ArrayList<Person> {
        val persons = ArrayList<Person>()
        for (i in 1..elements) {
            val string = getCustomizePersonString(i);
            persons.add(getPerson(string))
        }
        return persons;
    }

    private fun getCustomizePersonString(number: Int): String {
        return """{
    "id": $number,
    "firstName": "First name_$number",
    "lastName": "Last name_$number",
    "address": "Address_$number",
    "gender": "Male"
    }"""
    }
}