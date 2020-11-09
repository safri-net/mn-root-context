package net.safri.mn

import groovy.transform.ToString
import io.micronaut.core.annotation.Introspected

import javax.annotation.Nullable
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@ToString(includeNames = true, includePackage = false)
@Introspected
class PaginationCommand {

    @Min(1L)
    @Max(200L)
    @Nullable
    Integer perPage

    @Min(1L)
    @Nullable
    Integer page

    @Nullable
    List<String> orders

    @Nullable
    Collection<String> filters

    @Nullable
    String search
}
