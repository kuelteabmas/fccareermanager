package com.totaldevservices.performances.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString(exclude = {"negotiationDealDetail", "dealFinancialsDetail", "playerGrowthDetail"}) // Avoids cyclic references in toString()
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class MatchFactsSummaryRequest {

    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    UUID id;

    @Schema(name = "playerId", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    UUID playerId;

    @Schema(name = "age", example = "23")
    private int age;

    @Schema(name = "seasonYear", example = "2023")
    private int seasonYear;

    @Schema(name = "seasonTransferWindow", example = "Winter")
    private String seasonTransferWindow;

    @Schema(name = "date", example = "2024-15-06")
    private LocalDate date;

}
