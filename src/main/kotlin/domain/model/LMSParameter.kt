package com.xora.dev.rayan.ktor.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LMSParameter(
    val id: String?  = null,
    @SerialName("Sex")
    val sex: Int,
    @SerialName("Agemos")
    val agemos: Float,
    @SerialName("L")
    val l: Float,
    @SerialName("M")
    val m: Float,
    @SerialName("S")
    val s: Float,
    @SerialName("P3")
    val p3: Float,
    @SerialName("P5")
    val p5: Float,
    @SerialName("P10")
    val p10: Float,
    @SerialName("P25")
    val p25: Float,
    @SerialName("P50")
    val p50: Float,
    @SerialName("P75")
    val p75: Float,
    @SerialName("P85")
    val p85: Float,
    @SerialName("P90")
    val p90: Float,
    @SerialName("P95")
    val p95: Float,
    @SerialName("P97")
    val p97: Float,
)
