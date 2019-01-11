package org.study.javalin.models

data class ResourceModel constructor(
    val id: Int,
    val title: String,
    val description: String,
    val type: Type
) {
    enum class Type { BOOK, VIDEO, WORKSHOP, COURSE, STREAMING }
}