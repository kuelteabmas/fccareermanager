package com.totaldevservices.transferhistory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NegotiationDealDetailResponse {

    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @Schema(name = "transferhistory_id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID transferHistoryId;

    @Schema(name = "playerId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID playerId;

    @Schema(name = "dealType", example = "Loan", requiredMode = Schema.RequiredMode.REQUIRED)
    private String dealType;

    @Schema(name = "loanType", example = "LTB", requiredMode = Schema.RequiredMode.REQUIRED)
    private String loanType;

    @Schema(name = "parentTeam", example = "Thiep FC", requiredMode = Schema.RequiredMode.REQUIRED)
    private String parentTeam;

    @Schema(name = "tempTeam", example = "AC Lion", requiredMode = Schema.RequiredMode.REQUIRED)
    private String tempTeam;

    @Schema(name = "loanDurationInMonths", example = "6", requiredMode = Schema.RequiredMode.REQUIRED)
    private int loanDurationInMonths;

    @Schema(name = "contractStartDate", example = "2024-06-15", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate contractStartDate;

    @Schema(name = "contractEndDate", example = "2024-12-15", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate contractEndDate;

    @Schema(name = "playerSwappedId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID playerSwappedId;
}
