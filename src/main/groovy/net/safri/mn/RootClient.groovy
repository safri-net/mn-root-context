package net.safri.mn

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

import javax.annotation.Nullable
import javax.validation.Valid

@Client(id = "my-client", path = "/")
interface RootClient extends IListOperation {

    @Override
    @Get("/{?paginationCommand*}")
    HttpResponse<Collection<String>> list(@Valid @Nullable PaginationCommand paginationCommand)
}
