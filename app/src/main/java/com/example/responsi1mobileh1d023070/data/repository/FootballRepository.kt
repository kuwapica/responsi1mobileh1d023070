package com.example.responsi1mobileh1d023070.data.repository

import com.example.responsi1mobileh1d023070.data.model.TeamResponse
import com.example.responsi1mobileh1d023070.data.network.RetrofitInstance

class FootballRepository {
    private val api = RetrofitInstance.api

    private val apiKey = "3965a2b6ffda48e397b0da512feedaf1"

    private val juventusId = 109

    suspend fun getJuventusData() : TeamResponse {
        return api.getTeam(juventusId, apiKey)
    }


}