# Example Repo to demonstrate Problems with Root Context Controllers

After upgrading our apps to micronaut 2.1.* we encountered that applications that run 
on root context "/" no longer serve our list endpoint as it doesn't find the route.
Changing the controller root uri to anything else makes it work again.


## Non working Controller 
```groovy
@Controller("/")
class RootController {

    @Get("/{?paginationCommand*}")
    HttpResponse<Collection<String>> list(@Valid @Nullable PaginationCommand paginationCommand) {
        HttpResponse.ok(["will", "this", "work"])
    }
}
```  

## Working Controller 
```groovy
@Controller("/test")
class TestController {

    @Get("/{?paginationCommand*}")
    HttpResponse<Collection<String>> list(@Valid @Nullable PaginationCommand paginationCommand) {
        HttpResponse.ok(["will", "this", "work"])
    }
}
```  

Just run `./gradlew test` to reproduce the problem.

