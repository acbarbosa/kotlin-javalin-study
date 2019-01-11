package org.study.javalin

import com.github.kittinunf.fuel.Fuel
import java.nio.charset.Charset
import org.assertj.core.api.Assertions.assertThat
import org.eclipse.jetty.http.HttpStatus
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class ResourceTest {
    private val app = startServer()
    private val baseUrl = "http://localhost:${app.server.port()}"

    @Test
    fun `should receive sucessfully resource list data`() {
        val request = Fuel.get("$baseUrl/resources")
        val response = request.response().second
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK_200)
        assertThat(response.data.toString(Charset.defaultCharset())).isEqualTo("Show all resources")
        assertNotNull(response)
    }
}