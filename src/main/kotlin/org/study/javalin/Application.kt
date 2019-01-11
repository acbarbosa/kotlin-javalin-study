package org.study.javalin

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.json.JavalinJackson
import org.eclipse.jetty.http.HttpStatus
import org.slf4j.LoggerFactory

const val DEFAULT_PORT = 7000

class Application {
    val server: Javalin = Javalin.create()
    val log = LoggerFactory.getLogger(Application::class.java)

    init {
        server.routes { getRoutes() }
    }

    private fun getRoutes() {
        get("/") { context -> context.result("Hello World") }
        get("info") {
            context -> val jsonObject = object { var app = "Hello, World" }
            context.status(HttpStatus.OK_200).json(JavalinJackson.toJson(jsonObject))
        }

        path("resources") {
            get() { ctx -> ctx.result("Show all resources") }
        }
    }
}

fun startServer(): Application {
    val application = Application()
    application.server.start(DEFAULT_PORT)
    return application
}

fun main(vararg args: String) {
    startServer()
}
