package com.totaldevservices.performances.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Schema(name = "matchday_number", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int matchdayNumber;

    @Schema(name = "home_team_id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID homeTeamId;

    @Schema(name = "away_team_id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID awayTeamId;

    @Schema(name = "home_team_score", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
    private int homeTeamScore;

    @Schema(name = "away_team_score", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
    private int awayTeamScore;

    @Schema(name = "date", example = "2024-06-15", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate date;

    @Schema(name = "entryCreatedDateTime", example = "2024-06-15T21:37:11.676727", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime entryCreatedDateTime;

    @Schema(name = "entryLastUpdatedDateTime", example = "2024-06-15T21:37:11.676727", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime entryLastUpdatedDateTime;

    @Schema(name = "possession", example = "23.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private double possession;

    @Schema(name = "matchday_number", example = "6", requiredMode = Schema.RequiredMode.REQUIRED)
    private int ballRecoveryTimeInSeconds;

    @Schema(name = "shots", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int shots;

    @Schema(name = "expected_goals", example = "7.2", requiredMode = Schema.RequiredMode.REQUIRED)
    private double expectedGoals;

    @Schema(name = "passes", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int passes;

    @Schema(name = "tackles", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int tackles;

    @Schema(name = "tackles_won", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int tacklesWon;

    @Schema(name = "interceptions", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int interceptions;

    @Schema(name = "saves", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int saves;

    @Schema(name = "fouls", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int fouls;

    @Schema(name = "offsides", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int offsides;

    @Schema(name = "corners", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int corners;

    @Schema(name = "free_kicks", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int freeKicks;

    @Schema(name = "penalty_kicks", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int penaltyKicks;

    @Schema(name = "yellow_cards", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int yellowCards;

    @Schema(name = "red_cards", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int redCards;

    @Schema(name = "def_line_breaks_through", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int defenseLineBreaksThrough;

    @Schema(name = "def_line_breaks_around", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int defenseLineBreaksAround;

    @Schema(name = "def_line_breaks_over", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int defenseLineBreaksOver;

    @Schema(name = "def_line_breaks_attempted", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int defenseLineBreaksAttempted;

}
