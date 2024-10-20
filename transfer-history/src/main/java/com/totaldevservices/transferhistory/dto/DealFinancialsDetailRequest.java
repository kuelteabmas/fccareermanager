package com.totaldevservices.transferhistory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class DealFinancialsDetailRequest {

    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @Schema(name = "playerId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID playerId;

    @Schema(name = "preDealWage", example = "25.00")
    private double preDealWage;

    @Schema(name = "postDealWage", example = "25.00")
    private double postDealWage;

    @Schema(name = "releaseClauseAmount", example = "25.00")
    private double releaseClauseAmount;

    @Schema(name = "signingBonus", example = "25.00")
    private double signingBonus;

    @Schema(name = "performanceBonusType", example = "Goals")
    private String performanceBonusType;

    @Schema(name = "performanceBonusCount", example = "5")
    private int performanceBonusCount;

    @Schema(name = "performanceBonusSum", example = "25.00")
    private double performanceBonusSum;

    @Schema(name = "transfeeFee", example = "25.00")
    private double transfeeFee;

    @Schema(name = "sellonClauseAmount", example = "50.00")
    private double sellonClauseAmount;

}
