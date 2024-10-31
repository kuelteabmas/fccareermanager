package com.totaldevservices.transferhistory.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString(exclude = {"transferHistory"}) // Avoids cyclic references in toString()
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "deal_financials_details")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // serialize the entire object graph by properly configuring JSON annotations - avoids infinite cyclic loop and StackOverflowError
public class DealFinancialsDetail {

    @Id
    @UuidGenerator
    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "transferhistory_id", referencedColumnName = "id", nullable = false)
    private TransferHistory transferHistory;

    @Column(name = "player_id")
    @Schema(name = "playerId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
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

    @Column(name = "transfer_fee")
    @Schema(name = "transferFee", example = "25.00")
    private double transferFee;

    @Column(name = "sellon_clause_amount")
    @Schema(name = "sellonClauseAmount", example = "50.00")
    private double sellonClauseAmount;

}

