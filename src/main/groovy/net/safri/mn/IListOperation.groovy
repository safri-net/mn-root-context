package net.safri.mn

import io.micronaut.http.HttpResponse

import javax.annotation.Nullable
import javax.validation.Valid


interface IListOperation {

    HttpResponse<Collection<String>> list(@Valid @Nullable PaginationCommand paginationCommand)
}