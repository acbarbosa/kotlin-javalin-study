package org.study.javalin.controllers

import org.study.javalin.models.ResourceModel

class ResourceController {
    fun all(): Array<ResourceModel> {
        val resources: Array<ResourceModel> = arrayOf(ResourceModel(1, "O Mundo de Sofia", "História sobre uma garota que aprender filosofia através de cartas anônimas", ResourceModel.Type.BOOK))
        return resources
    }

    fun getResource(): ResourceModel {
        return ResourceModel(1, "O Mundo de Sofia", "História sobre uma garota que aprender filosofia através de cartas anônimas", ResourceModel.Type.BOOK)
    }
}