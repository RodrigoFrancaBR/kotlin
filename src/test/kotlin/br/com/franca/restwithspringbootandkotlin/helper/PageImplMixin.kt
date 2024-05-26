package br.com.franca.restwithspringbootandkotlin.helper

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest


class PageImplMixin<T> @JsonCreator constructor(
    @JsonProperty("content") content: List<T>?,
    @JsonProperty("number") number: Int,
    @JsonProperty("size") size: Int,
    @JsonProperty("totalElements") totalElements: Long,
) :
    PageImpl<T>(content!!, PageRequest.of(number, size), totalElements)