package br.com.franca.restwithspringbootandkotlin.helper

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonResponseDTO
import br.com.franca.restwithspringbootandkotlin.model.Person
import org.springframework.data.domain.*
import org.springframework.hateoas.Link
import org.springframework.hateoas.Links
import org.springframework.hateoas.PagedModel


object PageableHelper : AbstractHelper() {

    fun getDefaultPageable(): Pageable {
        return PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "id"))
//        val string = getDefaultPageableString()
//        return getPageable(string)
    }

    fun getDefaultPageImpl(): Page<Person> {
        val content = PersonModelEntityHelper.getPersonList(10)
        val pageable = PageableHelper.getDefaultPageable()
        return PageImpl(content, pageable, 10)
    }

    private fun getDefaultPageableString() =
        """{"pageNumber":0,"pageSize":10,"sort":{"empty":false,"unsorted":false,"sorted":true},"offset":0,"paged":true,"unpaged":false}"""

    private fun getPageable(string: String): Pageable {
        val messageError = "Error writeStringAsObject someString: $string someClass: ${Pageable::class.java}"
        return writeStringAsObjectOrElseThrow(string, Pageable::class.java, messageError) as Pageable
    }

    fun getPagedModel(size: Long, number: Long, totalElements: Long) : PagedModel<PersonResponseDTO>{
        val content = PersonResponseDTOHelper.getDefaultPersonResponseDTOList(10)

        content.forEach {
            it.add(
                Link.of("http://localhost:8080/person/${it.id}", "self"),
                Link.of("http://localhost:8080/person{?page,size,sort,direction}", "Persons"),

                )
            println("$it!")
        }

        val pageMetadata =
            PagedModel.PageMetadata(
                size,
                number,
                totalElements
            )
        val links = Links.of(
            mutableListOf(
                Link.of("http://localhost:8080/person?page=0&size=10&sort=id,asc", "first"),
                Link.of("http://localhost:8080/person?page=0&size=10&sort=id,asc", "self"),
                Link.of("http://localhost:8080/person?page=1&size=10&sort=id,asc", "next"),
                Link.of("http://localhost:8080/person?page=101&size=10&sort=id,asc", "last"),
            )
        )
        return PagedModel.of(content, pageMetadata, links)
    }
}