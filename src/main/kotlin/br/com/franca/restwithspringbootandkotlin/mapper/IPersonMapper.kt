package br.com.franca.restwithspringbootandkotlin.mapper

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.CreatePersonRequestDTO
import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonResponseDTO
import br.com.franca.restwithspringbootandkotlin.model.Person
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface IPersonMapper {

    fun toPersonResponseDTO(person: Person): PersonResponseDTO
    fun toPersonResponseDTOList(personList: List<Person>): List<PersonResponseDTO>
    fun personResponseDTOListToPersonList(personResponseDTOList: List<PersonResponseDTO>): List<Person>
    fun toPerson(personResponseDTO: PersonResponseDTO): Person
    fun toPerson(createPersonRequestDTO: CreatePersonRequestDTO): Person
    fun toPersonList(createPersonRequestDTOList: List<CreatePersonRequestDTO>): List<Person>
    fun toCreatePersonRequestDTO(person: Person): CreatePersonRequestDTO
    fun toCreatePersonRequestDTOList(personList: List<Person>): List<Person>
}