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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "transferhistory")
public class TransferHistoryItem {

    // TODO: Add constraints in model and in service impl

    @Id
    @UuidGenerator
    @Column(name = "transferhistory_id")
    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @Column(name = "player_name")
    @Schema(name = "player_name", example = "Dan Smith", requiredMode = Schema.RequiredMode.REQUIRED)
    private String playerName;

    @Column(name = "from_team")
    @Schema(name = "from_team", example = "Thiep FC", requiredMode = Schema.RequiredMode.REQUIRED)
    private String fromTeam;

    @Column(name = "to_team")
    @Schema(name = "to_team", example = "AC Lion", requiredMode = Schema.RequiredMode.REQUIRED)
    private String toTeam;

    @Column(name = "player_name")
    @Schema(name = "player_name", example = "LTB", requiredMode = Schema.RequiredMode.REQUIRED)
    private String loanType;

    @Column(name = "transferhistory_type")
    @Schema(name = "transferType", example = "Loan", requiredMode = Schema.RequiredMode.REQUIRED)
    private String transferType;

    @Column(name = "transferhistory_amount")
    @Schema(name = "amount", example = "25", requiredMode = Schema.RequiredMode.REQUIRED)
    private double wage;

    @Column(name = "transferhistory_amount")
    @Schema(name = "amount", example = "25", requiredMode = Schema.RequiredMode.REQUIRED)
    private double releaseClauseAmount;

    @Column(name = "transferhistory_amount")
    @Schema(name = "amount", example = "25", requiredMode = Schema.RequiredMode.REQUIRED)
    private double bonus;

    @Column(name = "transferhistory_amount")
    @Schema(name = "amount", example = "25", requiredMode = Schema.RequiredMode.REQUIRED)
    private double signonBonus;

    @Column(name = "transferhistory_amount")
    @Schema(name = "amount", example = "25", requiredMode = Schema.RequiredMode.REQUIRED)
    private double bonusType;

    @Column(name = "player_name")
    @Schema(name = "player_name", example = "Dan Smith", requiredMode = Schema.RequiredMode.REQUIRED)
    private double saleAmount;

    @Column(name = "transferhistory_duration")
    @Schema(name = "duration", example = "6", requiredMode = Schema.RequiredMode.REQUIRED)
    private int loanDurationInMonths;

    @Column(name = "transferhistory_duration")
    @Schema(name = "duration", example = "PT7M38S", requiredMode = Schema.RequiredMode.REQUIRED)
    private String playerStatus;

    @Column(name = "transferhistory_amount")
    @Schema(name = "amount", example = "25", requiredMode = Schema.RequiredMode.REQUIRED)
    private int playerMarketValue;

    @Column(name = "transferhistory_amount")
    @Schema(name = "amount", example = "Rotation", requiredMode = Schema.RequiredMode.REQUIRED)
    private String playerRole;

    @Column(name = "transferhistory_amount")
    @Schema(name = "amount", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
    private int contractLength;

    @Column(name = "transferhistory_duration")
    @Schema(name = "duration", example = "PT7M38S", requiredMode = Schema.RequiredMode.REQUIRED)
    private int preLoanPlayerOverrall;

    @Column(name = "transferhistory_duration")
    @Schema(name = "duration", example = "PT7M38S", requiredMode = Schema.RequiredMode.REQUIRED)
    private int postLoanPlayerOverrall;

    @Column(name = "transferhistory_duration")
    @Schema(name = "duration", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int age;

    @Column(name = "transferhistory_duration")
    @Schema(name = "duration", example = "PT7M38S", requiredMode = Schema.RequiredMode.REQUIRED)
    private double growthPercentage;

    @Column(name = "transferhistory_duration")
    @Schema(name = "duration", example = "PT7M38S", requiredMode = Schema.RequiredMode.REQUIRED)
    private int seasonYear;

    @Column(name = "transferhistory_duration")
    @Schema(name = "duration", example = "PT7M38S", requiredMode = Schema.RequiredMode.REQUIRED)
    private String seasonTransferWindow;

    @Column(name = "transferhistory_date")
    @Schema(name = "date", example = "2024-06-15")
    private LocalDate date;

    @Column(name = "transferhistory_datetime")
    @Schema(name = "entryCreated", example = "2024-06-15T21:37:11.676727")
    private LocalDateTime entryCreated;
}
