package com.xora.dev.rayan.ktor.domain.repository

import com.xora.dev.rayan.ktor.domain.model.LMSParameter
import com.xora.dev.rayan.ktor.domain.util.DataError
import com.xora.dev.rayan.ktor.domain.util.Result

interface LMSParameterRepository {
    suspend fun insertLMSParameterInBulk(lmsParameters: List<LMSParameter>): Result<Unit, DataError>
    suspend fun upsertLMSParameter(lmsParameter: LMSParameter): Result<Unit, DataError>
    suspend fun getLMSParameterBySexAndAgemos(sex:  Int, agemos: Float): Result<LMSParameter, DataError>
}