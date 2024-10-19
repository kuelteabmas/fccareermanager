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
@Table(name = "deal_financials_details")
public class DealFinancialsDetail {

    @Id
    @UuidGenerator
    @Column(name = "deal_financials_details_id")
    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @Column(name = "player_id")
    @Schema(name = "player_id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID playerId;

    @Column(name = "pre_deal_wage")
    @Schema(name = "preDealWage", example = "25.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private double preDealWage;

    @Column(name = "post_deal_wage")
    @Schema(name = "postDealWage", example = "25.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private double postDealWage;

    @Column(name = "release_clause_amount")
    @Schema(name = "releaseClauseAmount", example = "25.00")
    private double releaseClauseAmount;

    @Column(name = "signing_bonus")
    @Schema(name = "signingBonus", example = "25.00")
    private double signingBonus;

    @Column(name = "performance_bonus_type")
    @Schema(name = "performanceBonusType", example = "Goals")
    private String performanceBonusType;

    @Column(name = "performance_bonus_count")
    @Schema(name = "performanceBonusCount", example = "5")
    private int performanceBonusCount;

    @Column(name = "performance_bonus_sum")
    @Schema(name = "performanceBonusSum", example = "25.00")
    private double performanceBonusSum;

    @Column(name = "transfee_fee")
    @Schema(name = "transfeeFee", example = "25.00")
    private double transfeeFee;

    @Column(name = "sellon_clause_amount")
    @Schema(name = "sellonClauseAmount", example = "50.00")
    private double sellonClauseAmount;

}

