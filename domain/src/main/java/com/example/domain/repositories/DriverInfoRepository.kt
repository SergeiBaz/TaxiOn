package com.example.domain.repositories


import com.example.domain.entities.DriversOffer

interface DriverInfoRepository {
    suspend fun getDriverInfo(): DriversOffer
}