package br.com.franca.restwithspringbootandkotlin.mapper

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.CreatePersonRequestDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import br.com.franca.restwithspringbootandkotlin.domain.entity.Person as DomainEntityPerson
import br.com.franca.restwithspringbootandkotlin.model.Person as ModelEntityPerson

/**
 * trocar o pacote para assembler
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface IPersonMapper {

    fun toDomainEntity(createPersonRequestDTO: CreatePersonRequestDTO): br.com.franca.restwithspringbootandkotlin.domain.entity.Person

    fun toEntity(domainEntity: DomainEntityPerson): ModelEntityPerson
}