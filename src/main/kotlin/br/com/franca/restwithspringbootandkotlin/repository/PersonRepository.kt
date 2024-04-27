package br.com.franca.restwithspringbootandkotlin.repository

import br.com.franca.restwithspringbootandkotlin.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long?> {}