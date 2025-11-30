package com.xora.dev.rayan.ktor.presentation.config

import com.xora.dev.rayan.ktor.domain.repository.LMSParameterRepository
import com.xora.dev.rayan.ktor.presentation.routes.lmsParameterRoutes
import com.xora.dev.rayan.ktor.presentation.routes.root
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    install(Resources)

    val lmsParameterRepository: LMSParameterRepository by  inject()

    routing {
        root()
        lmsParameterRoutes(lmsParameterRepository)
    }
}