package com.xora.dev.rayan.ktor.data.mapper

import com.xora.dev.rayan.ktor.data.database.entity.LMSParameterEntity
import com.xora.dev.rayan.ktor.domain.model.LMSParameter

fun LMSParameterEntity.toLMSParameter(): LMSParameter {
    return LMSParameter(
        id = _id,
        sex = sex,
        agemos = agemos,
        l = l,
        m = m,
        s = s,
        p3 = p3,
        p5 = p5,
        p10 = p10,
        p25 = p25,
        p50 = p50,
        p75 = p75,
        p85 = p85,
        p90 = p90,
        p95 = p95,
        p97 = p97,
    )
}

fun LMSParameter.toLMSParameterEntity(): LMSParameterEntity {
    return LMSParameterEntity(
        sex = sex,
        agemos = agemos,
        l = l,
        m = m,
        s = s,
        p3 = p3,
        p5 = p5,
        p10 = p10,
        p25 = p25,
        p50 = p50,
        p75 = p75,
        p85 = p85,
        p90 = p90,
        p95 = p95,
        p97 = p97,
    )
}