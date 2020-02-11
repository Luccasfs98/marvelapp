package com.marvel.core.di

import com.marvel.core.BuildConfig
import com.marvel.core.network.MarvelService
import br.com.marvel.core.network.repository.MarvelRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    fun provideForecastApi(retrofit: Retrofit): MarvelService =
        retrofit.create(MarvelService::class.java)


    factory { provideOkHttpClient() }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}

val repositoryModule = module {

    fun provideRepository(marvelService: MarvelService): MarvelRepository {
        return MarvelRepository(marvelService)
    }

    single { provideRepository(get()) }
}
