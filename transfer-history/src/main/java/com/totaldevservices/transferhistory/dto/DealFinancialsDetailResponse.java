package com.totaldevservices.transferhistory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DealFinancialsDetailResponse {

    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @Schema(name = "transferhistory_id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID transferHistoryId;

    @Schema(name = "playerId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID playerId;

    @Schema(name = "preDealWage", example = "25.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private double preDealWage;

    @Schema(name = "postDealWage", example = "25.00", requiredMode = Schema.RequiredMode.REQUIRED)
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
