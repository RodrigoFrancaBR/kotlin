package br.com.franca.restwithspringbootandkotlin.controller.dto.v1

import org.springframework.hateoas.RepresentationModel
import org.springframework.hateoas.server.core.Relation

@Relation(collectionRelation = "Persons")
class PersonResponseDTO(
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""
) : RepresentationModel<PersonResponseDTO>()

