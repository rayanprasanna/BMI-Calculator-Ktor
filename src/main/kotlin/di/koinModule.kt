package com.xora.dev.rayan.ktor.di

import com.xora.dev.rayan.ktor.data.database.DatabaseFactory
import com.xora.dev.rayan.ktor.data.repository.LMSParameterRepositoryImpl
import com.xora.dev.rayan.ktor.domain.repository.LMSParameterRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val koinModule = module {
    single { DatabaseFactory.create() }
    singleOf(::LMSParameterRepositoryImpl).bind<LMSParameterRepository>()
}