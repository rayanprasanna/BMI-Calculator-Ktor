package com.xora.dev.rayan.ktor.presentation.config

import com.xora.dev.rayan.ktor.presentation.validator.validateLMSParameter
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*

fun Application.configureValidation() {
    // Currently no global validation configuration is needed.
    install(RequestValidation) {
        validateLMSParameter()
    }
}
