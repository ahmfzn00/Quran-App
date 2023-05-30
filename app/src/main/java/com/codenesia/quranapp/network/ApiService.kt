package com.codenesia.quranapp.network

import com.codenesia.quranapp.data.QuranResponse
import com.codenesia.quranapp.data.SuratResponse
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/v2/surat") //https://equran.id/api/v2/surat
    fun getQuran(): Call<QuranResponse>

    @GET("/api/v2/surat/{nomor}")
    fun getSurat(
        @Path("nomor") nomor: Int
    ): Call<SuratResponse> ////https://equran.id/api/v2/surat/1

}