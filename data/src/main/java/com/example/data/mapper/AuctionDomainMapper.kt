package com.example.data.mapper

import com.example.data.storage.local_db.entities.AuctionDbEntity as DataAuction
import com.example.domain.entities.Auction as DomainAuction

/*
internal class AuctionDomainMapper {

    fun toDomain(list: List<DataAuction>): List<DomainAuction> {
        return list.map { toDomain(it)}
    }

    internal fun toDomain(auction: DataAuction): DomainAuction {
        return DomainAuction(
            from = auction.from,
            to = auction.to,
        )
    }
}*/
