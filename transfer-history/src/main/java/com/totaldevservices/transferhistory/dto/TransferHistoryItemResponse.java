package com.totaldevservices.transferhistory.dto;

import com.totaldevservices.transferhistory.model.DealFinancialsDetail;
import com.totaldevservices.transferhistory.model.NegotiationDealDetail;
import com.totaldevservices.transferhistory.model.PlayerGrowthDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class TransferHistoryItemResponse {

    private UUID id;
    private UUID playerId;
    private int age;
    private int seasonYear;
    private String seasonTransferWindow;
    private LocalDate date;
    private LocalDateTime entryCreatedDateTime;
    private NegotiationDealDetail negotiationDealDetail;
    private DealFinancialsDetail dealFinancialsDetail;
    private PlayerGrowthDetail playerGrowthDetail;

}
