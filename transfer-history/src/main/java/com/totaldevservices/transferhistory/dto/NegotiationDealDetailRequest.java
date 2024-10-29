package com.totaldevservices.transferhistory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class NegotiationDealDetailRequest {

    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @Schema(name = "transferHistoryId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID transferHistoryId;

    @Schema(name = "playerId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID playerId;

    @Schema(name = "dealType", example = "Loan")
    private String dealType;

    @Schema(name = "loanType", example = "LTB")
    private String loanType;

    @Schema(name = "parentTeam", example = "Thiep FC")
    private String parentTeam;

    @Schema(name = "tempTeam", example = "AC Lion")
    private String tempTeam;

    @Schema(name = "loanDurationInMonths", example = "6")
    private int loanDurationInMonths;

    @Schema(name = "contractStartDate", example = "2024-06-15")
    private LocalDate contractStartDate;

    @Schema(name = "contractEndDate", example = "2024-12-15")
    private LocalDate contractEndDate;

    @Schema(name = "playerSwappedId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID playerSwappedId;
    
}
