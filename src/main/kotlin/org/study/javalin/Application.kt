package org.study.javalin

import io.javalin.Javalin

const val PORT = 7000

fun main(vararg args: String) {
    val app = Javalin.create().start(PORT)
    app.get("/") { ctx -> ctx.result("Hello World") }
}
