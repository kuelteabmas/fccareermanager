package com.totaldevservices.performances.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "match_facts_summary")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // serialize the entire object graph by properly configuring JSON annotations - avoids infinite cyclic loop and StackOverflowError
public class MatchFactsSummary {

    // TODO: Add constraints in model and in service impl

    @Id
    @UuidGenerator
    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    private UUID id;

    @Column(name = "matchday_number")
    @Schema(name = "matchday_number", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int matchdayNumber;

    @Column(name = "home_team_id")
    @Schema(name = "home_team_id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID homeTeamId;

    @Column(name = "away_team_id")
    @Schema(name = "away_team_id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID awayTeamId;

    @Column(name = "home_team_score")
    @Schema(name = "home_team_score", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
    private int homeTeamScore;

    @Column(name = "away_team_score")
    @Schema(name = "away_team_score", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
    private int awayTeamScore;

    @Column(name = "date")
    @Schema(name = "date", example = "2024-06-15", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate date;

    @Column(name = "entry_created_date_time")
    @Schema(name = "entryCreatedDateTime", example = "2024-06-15T21:37:11.676727", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime entryCreatedDateTime;

    @Column(name = "entry_last_updated_date_time")
    @Schema(name = "entryLastUpdatedDateTime", example = "2024-06-15T21:37:11.676727", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime entryLastUpdatedDateTime;

    @Column(name = "possession")
    @Schema(name = "possession", example = "23.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private double possession;

    @Column(name = "ball_recovery_time")
    @Schema(name = "ball_recovery_time", example = "6", requiredMode = Schema.RequiredMode.REQUIRED)
    private int ballRecoveryTimeInSeconds;

    @Column(name = "shots")
    @Schema(name = "shots", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int shots;

    @Column(name = "expected_goals")
    @Schema(name = "expected_goals", example = "7.2", requiredMode = Schema.RequiredMode.REQUIRED)
    private double expectedGoals;

    @Column(name = "passes")
    @Schema(name = "passes", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int passes;

    @Column(name = "tackles")
    @Schema(name = "tackles", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int tackles;

    @Column(name = "tackles_won")
    @Schema(name = "tackles_won", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int tacklesWon;

    @Column(name = "interceptions")
    @Schema(name = "interceptions", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int interceptions;

    @Column(name = "saves")
    @Schema(name = "saves", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int saves;

    @Column(name = "fouls")
    @Schema(name = "fouls", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int fouls;

    @Column(name = "offsides")
    @Schema(name = "offsides", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int offsides;

    @Column(name = "corners")
    @Schema(name = "corners", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int corners;

    @Column(name = "free_kicks")
    @Schema(name = "free_kicks", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int freeKicks;

    @Column(name = "penalty_kicks")
    @Schema(name = "penalty_kicks", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int penaltyKicks;

    @Column(name = "yellow_cards")
    @Schema(name = "yellow_cards", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int yellowCards;

    @Column(name = "red_cards")
    @Schema(name = "red_cards", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int redCards;

    @Column(name = "def_line_breaks_through")
    @Schema(name = "def_line_breaks_through", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int defenseLineBreaksThrough;

    @Column(name = "def_line_breaks_around")
    @Schema(name = "def_line_breaks_around", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int defenseLineBreaksAround;

    @Column(name = "def_line_breaks_over")
    @Schema(name = "def_line_breaks_over", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int defenseLineBreaksOver;

    @Column(name = "def_line_breaks_attempted")
    @Schema(name = "def_line_breaks_attempted", example = "23", requiredMode = Schema.RequiredMode.REQUIRED)
    private int defenseLineBreaksAttempted;
}
