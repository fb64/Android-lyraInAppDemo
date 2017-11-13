package com.lyranetwork.demo.payapp.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Retrofit available services interface
 */
internal interface APIInterface {
    @GET("performInit/{email}/{amount}/{mode}/{lang}/{card}")
    fun doGetPerformInit(@Path("email") email: String, @Path("amount") amount: String, @Path("mode") mode: String, @Path("lang") lang: String, @Path("card") card: String): Call<PerformInit>
}