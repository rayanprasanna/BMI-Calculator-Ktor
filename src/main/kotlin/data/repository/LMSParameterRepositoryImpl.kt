package com.xora.dev.rayan.ktor.data.repository

import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import com.xora.dev.rayan.ktor.data.database.entity.LMSParameterEntity
import com.xora.dev.rayan.ktor.data.mapper.toLMSParameter
import com.xora.dev.rayan.ktor.data.mapper.toLMSParameterEntity
import com.xora.dev.rayan.ktor.data.util.Constant
import com.xora.dev.rayan.ktor.domain.model.LMSParameter
import com.xora.dev.rayan.ktor.domain.repository.LMSParameterRepository
import com.xora.dev.rayan.ktor.domain.util.DataError
import com.xora.dev.rayan.ktor.domain.util.Result
import kotlinx.coroutines.flow.firstOrNull

class LMSParameterRepositoryImpl(
    mongoDatabase: MongoDatabase
): LMSParameterRepository {

    private val lmsParameterCollection = mongoDatabase.getCollection<LMSParameterEntity>(Constant.QUESTIONS_COLLECTION_NAME)

    override suspend fun insertLMSParameterInBulk(lmsParameters: List<LMSParameter>): Result<Unit, DataError> {
        return try {
            val lmsParameterEntity = lmsParameters.map { it.toLMSParameterEntity() }
            lmsParameterCollection.insertMany(lmsParameterEntity)
            Result.Success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Failure(DataError.Database)
        }
    }

    override suspend fun upsertLMSParameter(
        lmsParameter: LMSParameter
    ): Result<Unit, DataError> {
        return try {
            if (lmsParameter.id == null) {
                lmsParameterCollection.insertOne(lmsParameter.toLMSParameterEntity())
            } else {
                val filterQuery = Filters.eq(
                    LMSParameterEntity::_id.name, lmsParameter.id
                )
                val updateQuery = Updates.combine(
                    Updates.set(LMSParameterEntity::sex.name, lmsParameter.sex),
                    Updates.set(LMSParameterEntity::agemos.name, lmsParameter.agemos),
                    Updates.set(LMSParameterEntity::l.name, lmsParameter.l),
                    Updates.set(LMSParameterEntity::m.name, lmsParameter.m),
                    Updates.set(LMSParameterEntity::s.name, lmsParameter.s),
                    Updates.set(LMSParameterEntity::p3.name, lmsParameter.p3),
                    Updates.set(LMSParameterEntity::p5.name, lmsParameter.p5),
                    Updates.set(LMSParameterEntity::p10.name, lmsParameter.p10),
                    Updates.set(LMSParameterEntity::p25.name, lmsParameter.p25),
                    Updates.set(LMSParameterEntity::p50.name, lmsParameter.p50),
                    Updates.set(LMSParameterEntity::p75.name, lmsParameter.p75),
                    Updates.set(LMSParameterEntity::p85.name, lmsParameter.p85),
                    Updates.set(LMSParameterEntity::p90.name, lmsParameter.p90),
                    Updates.set(LMSParameterEntity::p95.name, lmsParameter.p95),
                    Updates.set(LMSParameterEntity::p97.name, lmsParameter.p97)
                )
                val updateResult = lmsParameterCollection.updateOne(filterQuery, updateQuery)
                if (updateResult.modifiedCount == 0L) {
                    return Result.Failure(DataError.NotFound)
                }
            }
            Result.Success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Failure(DataError.Database)
        }
    }

    override suspend fun getLMSParameterBySexAndAgemos(sex: Int, agemos: Float): Result<LMSParameter, DataError> {
        if (agemos.isNaN()) {
            return Result.Failure(DataError.Validation)
        }
        return try {
            val filterQuery = Filters.and(
                Filters.eq(LMSParameterEntity::sex.name, sex),
                Filters.eq(LMSParameterEntity::agemos.name, agemos)
            )
            val lmsParameterEntity = lmsParameterCollection
                .find(filter = filterQuery)
                .firstOrNull()

            if (lmsParameterEntity != null) {
                val lmsParameter = lmsParameterEntity.toLMSParameter()
                Result.Success(lmsParameter)
            } else {
                Result.Failure(DataError.NotFound)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Failure(DataError.Database)
        }
    }
}