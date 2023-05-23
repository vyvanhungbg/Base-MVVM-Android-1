package com.tieuvy.android.base_mvvm_android_1.data.datasource.remote.api

import android.util.Log
import com.tieuvy.android.base_mvvm_android_1.utils.constant.Constant
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.plugins.resources.Resources
import io.ktor.http.URLProtocol
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object AppClient {
    fun getInstance(): HttpClient {
        return HttpClient(CIO){
            headers {

            }
            defaultRequest {
                url(Constant.API.BASE)
            }
            install(Resources)
            install(ContentNegotiation) {
                json(Json {
                  /*  prettyPrint = true
                    explicitNulls = true*/
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                level = LogLevel.ALL
                logger = object: Logger {
                    override fun log(message: String) {
                        Log.e("HTTP Client", message)
                    }
                }

                /*filter { request ->
                    request.url.host.contains("ktor.io")
                }
                sanitizeHeader { header -> header == HttpHeaders.Authorization }*/
            }
        }
    }
}