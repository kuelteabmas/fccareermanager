package com.totaldevservices.transferhistory.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString(exclude = {"negotiationDealDetail", "dealFinancialsDetail", "playerGrowthDetail"}) // Avoids cyclic references in toString()
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "transferhistory")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // serialize the entire object graph by properly configuring JSON annotations - avoids infinite cyclic loop and StackOverflowError
public class TransferHistory {

    // TODO: Add constraints in model and in service impl

    @Id
    @UuidGenerator
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

    @Column(name = "entry_last_updated_date_time")
    @Schema(name = "entryLastUpdatedDateTime", example = "2024-06-15T21:37:11.676727")
    private LocalDateTime entryLastUpdatedDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "negotiation_deal_detail_id", referencedColumnName = "id")
    @Schema(name = "negotiationDealDetailsId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private NegotiationDealDetail negotiationDealDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deal_financials_detail_id", referencedColumnName = "id")
    @Schema(name = "negotiationDealDetailsId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private DealFinancialsDetail dealFinancialsDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_growth_detail_id", referencedColumnName = "id")
    @Schema(name = "playerGrowthDetailsId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private PlayerGrowthDetail playerGrowthDetail;

}
