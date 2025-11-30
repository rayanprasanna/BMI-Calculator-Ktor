package com.xora.dev.rayan.ktor.presentation

import com.xora.dev.rayan.ktor.presentation.config.configureKoin
import com.xora.dev.rayan.ktor.presentation.config.configureLogging
import com.xora.dev.rayan.ktor.presentation.config.configureRouting
import com.xora.dev.rayan.ktor.presentation.config.configureSerialization
import com.xora.dev.rayan.ktor.presentation.config.configureStatusPages
import com.xora.dev.rayan.ktor.presentation.config.configureValidation
import io.ktor.server.application.*
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) {
    EngineMain.main(args)
}

@Suppress("unused")
fun Application.module() {
    configureKoin()
    configureLogging()
    configureSerialization()
    configureRouting()
    configureValidation()
    configureStatusPages()
}
