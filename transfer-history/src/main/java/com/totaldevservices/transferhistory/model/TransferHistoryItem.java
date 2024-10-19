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
@Table(name = "transfer_history")
public class TransferHistoryItem {

    // TODO: Add constraints in model and in service impl

    @Id
    @UuidGenerator
    @Column(name = "transferhistory_id")
    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @Column(name = "player_id")
    @Schema(name = "player_id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID playerId;

    @Column(name = "age")
    @Schema(name = "age", example = "23")
    private int age;

    @Column(name = "season_year")
    @Schema(name = "seasonYear", example = "2023", requiredMode = Schema.RequiredMode.REQUIRED)
    private int seasonYear;

    @Column(name = "season_transfer_window")
    @Schema(name = "seasonTransferWindow", example = "Winter", requiredMode = Schema.RequiredMode.REQUIRED)
    private String seasonTransferWindow;

    @Column(name = "date")
    @Schema(name = "date", example = "2024-06-15", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate date;

    @Column(name = "entry_created_date_time")
    @Schema(name = "entryCreatedDateTime", example = "2024-06-15T21:37:11.676727")
    private LocalDateTime entryCreatedDateTime;

    @Column(name = "negotiation_deal_details_id")
    @Schema(name = "negotiationDealDetailsId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID negotiationDealDetailsId;

    @Column(name = "deal_financials_details_id")
    @Schema(name = "dealFinancialsDetailsId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID dealFinancialsDetailsId;

    @Column(name = "player_growth_details_id")
    @Schema(name = "playerGrowthDetailsId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID playerGrowthDetailsId;

}
