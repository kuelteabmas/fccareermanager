package com.totaldevservices.transferhistory.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "player_growth_details")
public class PlayerGrowthDetail {

    @Id
    @UuidGenerator
    @Column(name = "player_growth_details_id")
    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @Column(name = "player_id")
    @Schema(name = "playerId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID playerId;

    @Column(name = "pre_deal_player_status")
    @Schema(name = "preDealPlayerStatus", example = "Showing Great Potential", requiredMode = Schema.RequiredMode.REQUIRED)
    private String preDealPlayerStatus;

    @Column(name = "post_deal_player_status")
    @Schema(name = "postDealPlayerStatus", example = "An Exciting Prospect", requiredMode = Schema.RequiredMode.REQUIRED)
    private String postDealPlayerStatus;

    @Column(name = "pre_deal_player_overrall")
    @Schema(name = "preDealPlayerOverrall", example = "76", requiredMode = Schema.RequiredMode.REQUIRED)
    private int preDealPlayerOverrall;

    @Column(name = "post_deal_player_overrall")
    @Schema(name = "postDealPlayerOverrall", example = "82", requiredMode = Schema.RequiredMode.REQUIRED)
    private int postDealPlayerOverrall;

    @Column(name = "overall_growth_percentage")
    @Schema(name = "overallGrowthPercentage", example = "18.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private double overallGrowthPercentage;

    @Column(name = "updated_market_value")
    @Schema(name = "updatedMarketValue", example = "1600000.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private double updatedMarketValue;

}
