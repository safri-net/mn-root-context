package net.safri.mn

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.annotation.Nullable
import javax.validation.Valid

@Controller("/test")
class TestController implements IListOperation {

    @Get("/{?paginationCommand*}")
    HttpResponse<Collection<String>> list(@Valid @Nullable PaginationCommand paginationCommand) {
        HttpResponse.ok(["will", "this", "work"])
    }
}