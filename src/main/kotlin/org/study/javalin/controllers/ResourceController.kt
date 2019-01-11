package org.study.javalin.controllers

class ResourceController {
    fun all(): Array<Any> {
        val resources: Array<Any> = arrayOf("livro", "vídeo")
        return resources
    }
}