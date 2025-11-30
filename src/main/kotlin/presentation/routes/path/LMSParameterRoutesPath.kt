package com.xora.dev.rayan.ktor.presentation.routes.path

import io.ktor.resources.Resource

@Resource(path = "/cdc/lms")
class LMSParameterRoutesPath(){

    @Resource(path = "{sex}/{agemos}")
    data class BySexAndAgemos(
        val parent: LMSParameterRoutesPath = LMSParameterRoutesPath(),
        val sex: Int,
        val agemos: Float
    )

    @Resource(path = "bulk")
    data class Bulk(
        val parent: LMSParameterRoutesPath = LMSParameterRoutesPath()
    )
}