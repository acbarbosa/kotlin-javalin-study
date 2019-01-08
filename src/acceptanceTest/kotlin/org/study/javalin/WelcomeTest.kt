package org.study.javalin

import com.github.kittinunf.fuel.Fuel
import org.assertj.core.api.Assertions.assertThat
import org.eclipse.jetty.http.HttpStatus
import org.junit.jupiter.api.Test
import java.nio.charset.Charset

class WelcomeTest {

    private val app = startServer()
    private val baseUrl = "http://localhost:${app.server.port()}"

    @Test
    fun `should receive successfull welcome response on GET to root`() {
        val request = Fuel.get("$baseUrl/")
        val response = request.response().second

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK_200)
        assertThat(response.data.toString(Charset.defaultCharset())).isEqualTo("Hello World")
    }
}