package es.uniovi.networkapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import es.uniovi.networkapp.model.BusStatus
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://datos.gijon.es/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RestApiService {
    @GET("doc/transporte/busgijontr.json")
    suspend fun getStatusInfo(): BusStatus
}

object RestApi{
    val retrofitService: RestApiService by lazy{
        retrofit.create(RestApiService::class.java)
    }
}