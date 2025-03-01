package com.totaldevservices.performances.service;

import com.totaldevservices.performances.dto.MatchFactsSummaryRequest;
import com.totaldevservices.performances.dto.MatchFactsSummaryResponse;
import com.totaldevservices.performances.mapper.MatchFactsSummaryMapper;
import com.totaldevservices.performances.model.MatchFactsSummary;
import com.totaldevservices.performances.repository.MatchFactsSummaryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MatchFactsSummaryServiceImpl implements MatchFactsSummaryService {

    private MatchFactsSummaryRepository matchFactsSummaryRepository;

    private MatchFactsSummaryMapper matchFactsSummaryMapper;

    @Override
    public MatchFactsSummaryResponse getMatchFactsSummaryById(UUID matchFactsSummaryId) {
        Optional<MatchFactsSummary> matchFactsSummaryOptional =
                Optional.of(matchFactsSummaryRepository.findById(matchFactsSummaryId)
                .orElseThrow());

        return matchFactsSummaryMapper.map(matchFactsSummaryOptional.get());
    }

    @Override
    public List<MatchFactsSummaryResponse> getAllMatchFactsSummaries() {

        // findAll by playerId
        return matchFactsSummaryRepository.findAll()
                .stream()
                .map(matchFactsSummary -> matchFactsSummaryMapper.map(matchFactsSummary))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public MatchFactsSummaryResponse createMatchFactsSummary(MatchFactsSummaryRequest request) {


        MatchFactsSummary matchFactsSummary = MatchFactsSummary.builder()
                .id(request.getId())
                .matchdayNumber(request.getMatchdayNumber())
                .homeTeamId(request.getHomeTeamId())
                .homeTeamScore(request.getHomeTeamScore())
                .awayTeamId(request.getAwayTeamId())
                .awayTeamScore(request.getAwayTeamScore())
                .date(request.getDate())
                .entryCreatedDateTime(LocalDateTime.now())
                .entryLastUpdatedDateTime(LocalDateTime.now())
                .possession(request.getPossession())
                .ballRecoveryTimeInSeconds(request.getBallRecoveryTimeInSeconds())
                .shots(request.getShots())
                .expectedGoals(request.getExpectedGoals())
                .passes(request.getPasses())
                .tackles(request.getTackles())
                .tacklesWon(request.getTacklesWon())
                .interceptions(request.getInterceptions())
                .saves(request.getSaves())
                .fouls(request.getFouls())
                .offsides(request.getOffsides())
                .corners(request.getCorners())
                .freeKicks(request.getFreeKicks())
                .penaltyKicks(request.getPenaltyKicks())
                .yellowCards(request.getYellowCards())
                .redCards(request.getRedCards())
                .defenseLineBreaksThrough(request.getDefenseLineBreaksThrough())
                .defenseLineBreaksAround(request.getDefenseLineBreaksAround())
                .defenseLineBreaksOver(request.getDefenseLineBreaksOver())
                .defenseLineBreaksAttempted(request.getDefenseLineBreaksAttempted())
                .build();

        matchFactsSummaryRepository.save(matchFactsSummary);

        return matchFactsSummaryMapper.map(matchFactsSummary);
    }

    @Transactional
    @Override
    public MatchFactsSummaryResponse updateMatchFactsSummary(MatchFactsSummaryRequest request) {

        MatchFactsSummary matchFactsSummary = matchFactsSummaryRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("MatchFactsSummary not found with id: " + request.getId()));

        matchFactsSummary.setId(matchFactsSummary.getId());
        matchFactsSummary.setMatchdayNumber(request.getMatchdayNumber());
        matchFactsSummary.setHomeTeamId(request.getHomeTeamId());
        matchFactsSummary.setHomeTeamScore(request.getHomeTeamScore());
        matchFactsSummary.setAwayTeamId(request.getAwayTeamId());
        matchFactsSummary.setAwayTeamScore(request.getAwayTeamScore());
        matchFactsSummary.setDate(request.getDate());
        matchFactsSummary.setEntryLastUpdatedDateTime(LocalDateTime.now());
        matchFactsSummary.setPossession(request.getPossession());
        matchFactsSummary.setBallRecoveryTimeInSeconds(request.getBallRecoveryTimeInSeconds());
        matchFactsSummary.setShots(request.getShots());
        matchFactsSummary.setExpectedGoals(request.getExpectedGoals());
        matchFactsSummary.setPasses(request.getPasses());
        matchFactsSummary.setTackles(request.getTackles());
        matchFactsSummary.setTacklesWon(request.getTacklesWon());
        matchFactsSummary.setInterceptions(request.getInterceptions());
        matchFactsSummary.setSaves(request.getSaves());
        matchFactsSummary.setFouls(request.getFouls());
        matchFactsSummary.setOffsides(request.getOffsides());
        matchFactsSummary.setCorners(request.getCorners());
        matchFactsSummary.setFreeKicks(request.getFreeKicks());
        matchFactsSummary.setPenaltyKicks(request.getPenaltyKicks());
        matchFactsSummary.setYellowCards(request.getYellowCards());
        matchFactsSummary.setRedCards(request.getRedCards());
        matchFactsSummary.setDefenseLineBreaksThrough(request.getDefenseLineBreaksThrough());
        matchFactsSummary.setDefenseLineBreaksAround(request.getDefenseLineBreaksAround());
        matchFactsSummary.setDefenseLineBreaksOver(request.getDefenseLineBreaksOver());
        matchFactsSummary.setDefenseLineBreaksAttempted(request.getDefenseLineBreaksAttempted());

        // todo: check if matchFactsSummary is valid

        matchFactsSummaryRepository.save(matchFactsSummary);

        return matchFactsSummaryMapper.map(matchFactsSummary);
    }

    @Override
    public void deleteMatchFactsSummary(UUID id) {
        Optional<MatchFactsSummary> matchFactsSummaryOptional = matchFactsSummaryRepository.findById(id);

        // TODO: Throw Exception if ID doesn't exist in db

        matchFactsSummaryRepository.delete(matchFactsSummaryOptional.get());
    }
}
