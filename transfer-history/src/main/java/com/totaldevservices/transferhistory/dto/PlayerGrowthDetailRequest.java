package com.totaldevservices.transferhistory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class PlayerGrowthDetailRequest {

    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @Schema(name = "playerId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID playerId;

    @Schema(name = "preDealPlayerStatus", example = "Showing Great Potential")
    private String preDealPlayerStatus;

    @Schema(name = "postDealPlayerStatus", example = "An Exciting Prospect")
    private String postDealPlayerStatus;

    @Schema(name = "preDealPlayerOverrall", example = "76")
    private int preDealPlayerOverrall;

    @Schema(name = "postDealPlayerOverrall", example = "82")
    private int postDealPlayerOverrall;

    @Schema(name = "overallGrowthPercentage", example = "18.00")
    private double overallGrowthPercentage;

    @Schema(name = "updatedMarketValue", example = "1600000.00")
    private double updatedMarketValue;
}
