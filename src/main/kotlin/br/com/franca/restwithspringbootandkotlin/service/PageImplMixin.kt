package br.com.franca.restwithspringbootandkotlin.service

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest

data class PageImplMixin<T> @JsonCreator constructor(

    @JsonProperty("content") val contente: List<T>?,
    @JsonProperty("number") val numbere: Int,
    @JsonProperty("size") val sizee: Int,
    @JsonProperty("totalElements") val totalElementss: Long
) : PageImpl<T>(contente!!, PageRequest.of(numbere, sizee), totalElementss)
