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
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "negotiation_deal_details")
public class NegotiationDealDetail {

     @Id
     @UuidGenerator
     @Column(name = "negotiation_deal_details_id")
     @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
     private UUID id;

     @Column(name = "deal_type")
     @Schema(name = "dealType", example = "Loan", requiredMode = Schema.RequiredMode.REQUIRED)
     private String dealType;

     @Column(name = "loan_type")
     @Schema(name = "loanType", example = "LTB", requiredMode = Schema.RequiredMode.REQUIRED)
     private String loanType;

     @Column(name = "parent_team")
     @Schema(name = "parentTeam", example = "Thiep FC", requiredMode = Schema.RequiredMode.REQUIRED)
     private String parentTeam;

     @Column(name = "tempTeam")
     @Schema(name = "tempTeam", example = "AC Lion", requiredMode = Schema.RequiredMode.REQUIRED)
     private String tempTeam;

     @Column(name = "loan_duration_in_months")
     @Schema(name = "loanDurationInMonths", example = "6", requiredMode = Schema.RequiredMode.REQUIRED)
     private int loanDurationInMonths;

     @Column(name = "contract_start_date")
     @Schema(name = "contractStartDate", example = "2024-06-15", requiredMode = Schema.RequiredMode.REQUIRED)
     private LocalDate contractStartDate;

     @Column(name = "contract_end_date")
     @Schema(name = "duration", example = "2024-06-15", requiredMode = Schema.RequiredMode.REQUIRED)
     private LocalDate contractEndDate;

     @Id
     @Column(name = "player_swapped_id")
     @Schema(name = "playerSwappedId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
     private UUID playerSwappedId;
}
