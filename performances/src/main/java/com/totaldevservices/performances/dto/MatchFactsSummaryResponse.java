package com.totaldevservices.performances.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchFactsSummaryResponse {

    private UUID id;
    private int matchdayNumber;
    private UUID homeTeamId;
    private UUID awayTeamId;
    private int homeTeamScore;
    private int awayTeamScore;
    private LocalDate date;
    private LocalDateTime entryCreatedDateTime;
    private LocalDateTime entryLastUpdatedDateTime;
    private double possession;
    private int ballRecoveryTimeInSeconds;
    private int shots;
    private double expectedGoals;
    private int passes;
    private int tackles;
    private int tacklesWon;
    private int interceptions;
    private int saves;
    private int fouls;
    private int offsides;
    private int corners;
    private int freeKicks;
    private int penaltyKicks;
    private int yellowCards;
    private int redCards;
    private int defenseLineBreaksThrough;
    private int defenseLineBreaksAround;
    private int defenseLineBreaksOver;
    private int defenseLineBreaksAttempted;
}
