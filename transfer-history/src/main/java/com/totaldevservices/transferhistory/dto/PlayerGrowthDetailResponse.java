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
public class PlayerGrowthDetailResponse {

    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @Schema(name = "transferhistory_id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID transferHistoryId;

    @Schema(name = "playerId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID playerId;

    @Schema(name = "preDealPlayerStatus", example = "Showing Great Potential", requiredMode = Schema.RequiredMode.REQUIRED)
    private String preDealPlayerStatus;

    @Schema(name = "postDealPlayerStatus", example = "An Exciting Prospect", requiredMode = Schema.RequiredMode.REQUIRED)
    private String postDealPlayerStatus;

    @Schema(name = "preDealPlayerOverrall", example = "76", requiredMode = Schema.RequiredMode.REQUIRED)
    private int preDealPlayerOverrall;

    @Schema(name = "postDealPlayerOverrall", example = "82", requiredMode = Schema.RequiredMode.REQUIRED)
    private int postDealPlayerOverrall;

    @Schema(name = "overallGrowthPercentage", example = "18.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private double overallGrowthPercentage;

    @Schema(name = "updatedMarketValue", example = "1600000.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private double updatedMarketValue;
}
