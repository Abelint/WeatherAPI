package com.example.testproject

import kotlinx.serialization.Serializable

@Serializable
data class Data(val a: Int, val b: String)

@Serializable
data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val utc_offset_seconds: Int,
    val timezone: String,
    val timezone_abbreviation: String,
    val elevation: Int,
    val hourly_units: HourlyUnits,
    val hourly: HourlyData
)

@Serializable
data class HourlyUnits(
    val time: String,
    val temperature_2m: String
)

@Serializable
data class HourlyData(
    val time: List<String>,
    val temperature_2m: List<Double>
)