package org.study.javalin

import com.github.kittinunf.fuel.Fuel
import org.assertj.core.api.Assertions.assertThat
import org.eclipse.jetty.http.HttpStatus
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class ResourceTest {
    private val app = startServer()
    private val baseUrl = "http://localhost:${app.server.port()}"

    @Test
    fun `should receive successfully resource list data`() {
        val request = Fuel.get("$baseUrl/resources")
        val response = request.response().second
        val expectedBody = """["livro","vídeo"]"""
        val responseBodyMatch = "Body : \\((.*)\\)".toRegex().find(response.toString())
        val (Unit, bodyValue) = responseBodyMatch!!.groupValues
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK_200)
        assertThat(bodyValue).isEqualTo(expectedBody)
        assertNotNull(response)
    }
}