package org.study.javalin

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get

const val DEFAULT_PORT = 7000

class Application {
    val server: Javalin = Javalin.create()

    init {
        server.routes { getRoutes() }
    }

    private fun getRoutes() {
        get("/") { context -> context.result("Hello World") }
        get("info") { }
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
