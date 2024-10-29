package com.totaldevservices.transferhistory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferHistoryResponse {

    private UUID id;
    private UUID playerId;
    private int age;
    private int seasonYear;
    private String seasonTransferWindow;
    private LocalDate date;
    private LocalDateTime entryCreatedDateTime;
    private NegotiationDealDetailResponse negotiationDealDetail;
    private DealFinancialsDetailResponse dealFinancialsDetail;
    private PlayerGrowthDetailResponse playerGrowthDetail;

}
