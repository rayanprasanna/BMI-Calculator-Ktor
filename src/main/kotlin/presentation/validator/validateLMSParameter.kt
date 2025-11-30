package com.xora.dev.rayan.ktor.presentation.validator

import com.xora.dev.rayan.ktor.domain.model.LMSParameter
import io.ktor.server.plugins.requestvalidation.*

fun RequestValidationConfig.validateLMSParameter() {
    validate<LMSParameter> { lmsParameter ->
        when {
            lmsParameter.sex !in 1..2 -> {
                ValidationResult.Invalid(
                    reason = "Sex must be 1 or 2."
                )
            }
            lmsParameter.agemos.isNaN() || lmsParameter.agemos < 0 -> {
                ValidationResult.Invalid(
                    reason = "Agemos must be a non-negative number."
                )
            }
            lmsParameter.l.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "L must be a number."
                )
            }
            lmsParameter.m.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "M must be a number."
                )
            }
            lmsParameter.s.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "S must be a number."
                )
            }
            lmsParameter.p3.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "P3 must be a number."
                )
            }
            lmsParameter.p5.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "P5 must be a number."
                )
            }
            lmsParameter.p10.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "P10 must be a number."
                )
            }
            lmsParameter.p25.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "P25 must be a number."
                )
            }
            lmsParameter.p50.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "P50 must be a number."
                )
            }
            lmsParameter.p75.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "P75 must be a number."
                )
            }
            lmsParameter.p85.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "P85 must be a number."
                )
            }
            lmsParameter.p90.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "P90 must be a number."
                )
            }
            lmsParameter.p95.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "P95 must be a number."
                )
            }
            lmsParameter.p97.isNaN() -> {
                ValidationResult.Invalid(
                    reason = "P97 must be a number."
                )
            }
            else -> {
                ValidationResult.Valid
            }
        }
    }
}