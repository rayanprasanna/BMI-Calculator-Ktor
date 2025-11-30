package com.xora.dev.rayan.ktor.data.database.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Suppress("ANNOTATION_WILL_BE_APPLIED_ALSO_TO_PROPERTY_OR_FIELD")
data class LMSParameterEntity(
    @BsonId
    val _id: String = ObjectId().toString(),
    val sex: Int,
    val agemos: Float,
    val l: Float,
    val m: Float,
    val s: Float,
    val p3: Float,
    val p5: Float,
    val p10: Float,
    val p25: Float,
    val p50: Float,
    val p75: Float,
    val p85: Float,
    val p90: Float,
    val p95: Float,
    val p97: Float,
)