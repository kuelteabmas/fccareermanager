package com.totaldevservices.performances.mapper;

import com.totaldevservices.performances.dto.MatchFactsSummaryResponse;
import com.totaldevservices.performances.model.MatchFactsSummary;
import org.springframework.stereotype.Service;

@Service
public class MatchFactsSummaryMapper {

    public MatchFactsSummaryResponse map(MatchFactsSummary matchFactsSummary) {

        return MatchFactsSummaryResponse.builder()
                .id(matchFactsSummary.getId())
                .matchdayNumber(matchFactsSummary.getMatchdayNumber())
                .homeTeamId(matchFactsSummary.getHomeTeamId())
                .homeTeamScore(matchFactsSummary.getHomeTeamScore())
                .awayTeamId(matchFactsSummary.getAwayTeamId())
                .awayTeamScore(matchFactsSummary.getAwayTeamScore())
                .date(matchFactsSummary.getDate())
                .entryCreatedDateTime(matchFactsSummary.getEntryCreatedDateTime())
                .entryLastUpdatedDateTime(matchFactsSummary.getEntryLastUpdatedDateTime())
                .possession(matchFactsSummary.getPossession())
                .ballRecoveryTimeInSeconds(matchFactsSummary.getBallRecoveryTimeInSeconds())
                .shots(matchFactsSummary.getShots())
                .expectedGoals(matchFactsSummary.getExpectedGoals())
                .passes(matchFactsSummary.getPasses())
                .tackles(matchFactsSummary.getTackles())
                .tacklesWon(matchFactsSummary.getTacklesWon())
                .interceptions(matchFactsSummary.getInterceptions())
                .saves(matchFactsSummary.getSaves())
                .fouls(matchFactsSummary.getFouls())
                .offsides(matchFactsSummary.getOffsides())
                .corners(matchFactsSummary.getCorners())
                .freeKicks(matchFactsSummary.getFreeKicks())
                .penaltyKicks(matchFactsSummary.getPenaltyKicks())
                .yellowCards(matchFactsSummary.getYellowCards())
                .redCards(matchFactsSummary.getRedCards())
                .defenseLineBreaksThrough(matchFactsSummary.getDefenseLineBreaksThrough())
                .defenseLineBreaksAround(matchFactsSummary.getDefenseLineBreaksAround())
                .defenseLineBreaksOver(matchFactsSummary.getDefenseLineBreaksOver())
                .defenseLineBreaksAttempted(matchFactsSummary.getDefenseLineBreaksAttempted())
                .build();
    }
}
