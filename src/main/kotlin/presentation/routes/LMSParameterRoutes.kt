package com.xora.dev.rayan.ktor.presentation.routes

import com.xora.dev.rayan.ktor.domain.model.LMSParameter
import com.xora.dev.rayan.ktor.domain.repository.LMSParameterRepository
import com.xora.dev.rayan.ktor.domain.util.onFailure
import com.xora.dev.rayan.ktor.domain.util.onSuccess
import com.xora.dev.rayan.ktor.presentation.routes.path.LMSParameterRoutesPath
import com.xora.dev.rayan.ktor.presentation.util.respondWithError
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.Route

fun Route.lmsParameterRoutes(
    repository: LMSParameterRepository
) {
    post<LMSParameterRoutesPath> {
        val lms = call.receive<LMSParameter>()
        repository.upsertLMSParameter(lms)
            .onSuccess {
                call.respond(
                    message = "Data added successfully",
                    status = HttpStatusCode.Created
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    post<LMSParameterRoutesPath.Bulk> {
        val lmsParameter = call.receive<List<LMSParameter>>()
        repository.insertLMSParameterInBulk(lmsParameter)
            .onSuccess {
                call.respond(
                    message = "CDC data added",
                    status = HttpStatusCode.Created
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<LMSParameterRoutesPath.BySexAndAgemos> { path ->
        repository.getLMSParameterBySexAndAgemos(path.sex, path.agemos)
            .onSuccess { lmsParameter ->
                call.respond(
                    message = lmsParameter,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }
}