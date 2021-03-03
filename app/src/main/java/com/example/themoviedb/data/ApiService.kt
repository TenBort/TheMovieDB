package com.example.themoviedb.data


import com.example.themoviedb.data.model.FilmPager
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class ApiService {

    private val client by lazy {
        HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    Json {
                        encodeDefaults = true
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
                expectSuccess = true
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }

    suspend fun getFilms(): FilmPager =
        client.get<HttpResponse>(Constants.getFilms()).call.receive()
}
