package br.com.franca.restwithspringbootandkotlin.mapper

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.CreatePersonRequestDTO
import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonResponseDTO
import br.com.franca.restwithspringbootandkotlin.model.Person
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

/**
 * trocar o pacote para assembler
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface IPersonMapper {

    // ok
    fun toDomainEntity(createPersonRequestDTO: CreatePersonRequestDTO): br.com.franca.restwithspringbootandkotlin.domain.entity.Person

    fun toEntity(domainEntity: br.com.franca.restwithspringbootandkotlin.domain.entity.Person): Person

    fun toPersonResponseDTO(person: Person): PersonResponseDTO
    fun toPersonResponseDTOList(personList: List<Person>): List<PersonResponseDTO>
    fun personResponseDTOListToPersonList(personResponseDTOList: List<PersonResponseDTO>): List<Person>
    fun toPerson(personResponseDTO: PersonResponseDTO): Person
    fun toPerson(createPersonRequestDTO: CreatePersonRequestDTO): Person
    fun toPersonList(createPersonRequestDTOList: List<CreatePersonRequestDTO>): List<Person>
    fun toCreatePersonRequestDTO(person: Person): CreatePersonRequestDTO
    fun toCreatePersonRequestDTOList(personList: List<Person>): List<Person>

}