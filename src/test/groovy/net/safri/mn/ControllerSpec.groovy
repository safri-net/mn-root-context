package net.safri.mn

import io.micronaut.context.annotation.Property
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
@Property(name = "micronaut.server.port", value = "8080")
@Property(name = "micronaut.http.services.my-client.url", value = "http://localhost:8080")
class ControllerSpec extends Specification {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @Inject
    RootClient rootClient

    @Shared @Inject
    TestClient testClient


    void "test if controller on root context returns expected result"() {
        given:
        HttpResponse response = rootClient.list(null)

        expect:
        response.status == HttpStatus.OK
    }

    void "test if controller on test context returns expected result"() {
        given:
        HttpResponse response = testClient.list(null)

        expect:
        response.status == HttpStatus.OK
    }
}
