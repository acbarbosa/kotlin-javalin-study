package org.study.javalin

import com.github.kittinunf.fuel.Fuel
import org.assertj.core.api.Assertions.assertThat
import org.eclipse.jetty.http.HttpStatus
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull
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
        assertNotNull(response)
    }

    @Test
    fun `should check if exists app info endpoint`() {
        val request = Fuel.get("$baseUrl/info")
        val response = request.response().second
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK_200)
        assertNotNull(response)
    }
}