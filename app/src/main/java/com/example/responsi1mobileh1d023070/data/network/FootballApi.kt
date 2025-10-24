package com.example.responsi1mobileh1d023070.data.network

import androidx.constraintlayout.motion.widget.Key
import com.example.responsi1mobileh1d023070.data.model.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballApi {
    @GET("teams/{id}")
    suspend fun getTeam(
        @Path("id") teamId: Int,
        @Header("X-Auth-Token") apiKey: String
    ): TeamResponse
}