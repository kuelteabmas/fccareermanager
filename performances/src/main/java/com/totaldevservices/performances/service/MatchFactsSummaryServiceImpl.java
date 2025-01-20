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
        Optional<MatchFactsSummary> matchFactsSummaryItemOptional =
                Optional.of(matchFactsSummaryRepository.findById(matchFactsSummaryId)
                .orElseThrow());

        return matchFactsSummaryMapper.map(matchFactsSummaryItemOptional.get());
    }

    @Override
    public List<MatchFactsSummaryResponse> getAllMatchFactsSummaries() {

        /** Rework idea for performanace
         * findAll for negotiationDealDetailRepository, dealFinancialsDetailRepository and playerGrowthDetailRepository
         * then store in cache (redis)
         * parse data and build response for getAllMatchFactsSummaryItems()
         **/

        // findAll by playerId
        return matchFactsSummaryRepository.findAll()
                .stream()
                .map(matchFactsSummaryItem -> matchFactsSummaryMapper.map(matchFactsSummaryItem))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public MatchFactsSummaryResponse createMatchFactsSummary(MatchFactsSummaryRequest request) {

        // TODO: Check if the playerId exists before continuing once player db work is complete


        MatchFactsSummary matchFactsSummary = MatchFactsSummary.builder()
                .playerId(request.getPlayerId())
                .age(request.getAge())
                .seasonYear(request.getSeasonYear())
                .seasonTransferWindow(request.getSeasonTransferWindow())
                .date(request.getDate())
                .entryCreatedDateTime(LocalDateTime.now())
                .build();

        matchFactsSummaryRepository.save(matchFactsSummary);

        return matchFactsSummaryMapper.map(matchFactsSummary);
    }

    @Transactional
    @Override
    public MatchFactsSummaryResponse updateMatchFactsSummary(MatchFactsSummaryRequest request) {

        MatchFactsSummary matchFactsSummary = matchFactsSummaryRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("MatchFactsSummary not found with id: " + request.getId()));


        // TODO: Check that trasnferhistoryId matches in all related tables (negotiationDealDetail, dealFinancialsDetail, playerGrowthDetail)
//            if ((matchFactsSummary.getId() != negotiationDealDetail.getMatchFactsSummary().getId()) ||
//                    (matchFactsSummary.getId() != dealFinancialsDetail.getMatchFactsSummary().getId()) ||
//                    (matchFactsSummary.getId() != playerGrowthDetail.getMatchFactsSummary().getId())) {
//                  throw new Exception();
//            }

        // TODO: Check if request and existing db record are different prior to making update call

        // TODO: Check if request body is valid


        matchFactsSummary.setId(matchFactsSummary.getId());
        matchFactsSummary.setPlayerId(request.getPlayerId());
        matchFactsSummary.setAge(request.getAge());
        matchFactsSummary.setSeasonYear(request.getSeasonYear());
        matchFactsSummary.setSeasonTransferWindow(request.getSeasonTransferWindow());
        matchFactsSummary.setDate(request.getDate());
        matchFactsSummary.setEntryLastUpdatedDateTime(LocalDateTime.now());

        // todo: check if matchFactsSummaryItem is valid

        matchFactsSummaryRepository.save(matchFactsSummary);

        return matchFactsSummaryMapper.map(matchFactsSummary);
    }

    @Override
    public void deleteMatchFactsSummary(UUID id) {
        Optional<MatchFactsSummary> matchFactsSummaryItemOptional = matchFactsSummaryRepository.findById(id);

        // TODO: Throw Exception if ID doesn't exist in db

        matchFactsSummaryRepository.delete(matchFactsSummaryItemOptional.get());
    }
}
