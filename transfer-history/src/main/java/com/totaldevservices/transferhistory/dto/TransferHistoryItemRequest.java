package com.totaldevservices.transferhistory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class TransferHistoryItemRequest {

    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    UUID id;

    @Schema(name = "playerId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    UUID playerId;

    @Schema(name = "age", example = "23")
    private int age;

    @Schema(name = "seasonYear", example = "2023")
    private int seasonYear;

    @Schema(name = "seasonTransferWindow", example = "Winter")
    private String seasonTransferWindow;

    @Schema(name = "date", example = "2024-15-06")
    private LocalDate date;

    @Schema(name = "negotiationDealDetailsId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID negotiationDealDetailsId;

    @Schema(name = "dealFinancialsDetailsId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID dealFinancialsDetailsId;

    @Schema(name = "playerGrowthDetailsId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID playerGrowthDetailsId;
}
