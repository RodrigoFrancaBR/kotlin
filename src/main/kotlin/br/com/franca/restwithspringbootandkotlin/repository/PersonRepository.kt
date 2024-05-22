package br.com.franca.restwithspringbootandkotlin.repository

import br.com.franca.restwithspringbootandkotlin.model.Person
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long?> {

    fun findByFirstName(pageable: Pageable, firstName: String): Page<Person>
    fun findByFirstNameContaining(pageable: Pageable, letter: String): Page<Person>
}