package org.study.javalin

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get

const val DEFAULT_PORT = 7000

class Application {
    val app: Javalin

    init {
        app = Javalin.create()
        app.routes { getRoutes() }
    }

    private fun getRoutes() {
        get("/") { context -> context.result("Hello World") }
    }
}

fun main(vararg args: String) {
    val application = Application()
    application.app.start(DEFAULT_PORT)
}
