package com.totaldevservices.transferhistory.service;

import com.totaldevservices.transferhistory.dto.TransferHistoryRequest;
import com.totaldevservices.transferhistory.dto.TransferHistoryResponse;
import com.totaldevservices.transferhistory.mapper.TransferHistoryMapper;
import com.totaldevservices.transferhistory.model.DealFinancialsDetail;
import com.totaldevservices.transferhistory.model.NegotiationDealDetail;
import com.totaldevservices.transferhistory.model.PlayerGrowthDetail;
import com.totaldevservices.transferhistory.model.TransferHistory;
import com.totaldevservices.transferhistory.repository.DealFinancialsDetailRepository;
import com.totaldevservices.transferhistory.repository.NegotiationDealDetailRepository;
import com.totaldevservices.transferhistory.repository.PlayerGrowthDetailRepository;
import com.totaldevservices.transferhistory.repository.TransferHistoryRepository;
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
public class TransferHistoryServiceImpl implements TransferHistoryService {

    private NegotiationDealDetailRepository negotiationDealDetailRepository;
    private DealFinancialsDetailRepository dealFinancialsDetailRepository;
    private PlayerGrowthDetailRepository playerGrowthDetailRepository;
    private TransferHistoryRepository transferHistoryRepository;

    private NegotiationDealDetailService negotiationDealDetailService;
    private DealFinancialsDetailService dealFinancialsDetailService;
    private PlayerGrowthDetailService playerGrowthDetailService;

    private TransferHistoryMapper transferHistoryMapper;

    @Override
    public TransferHistoryResponse getTransferHistoryById(UUID transferHistoryId) {
        Optional<TransferHistory> transferHistoryItemOptional =
                Optional.of(transferHistoryRepository.findById(transferHistoryId)
                .orElseThrow());

        return transferHistoryMapper.map(transferHistoryItemOptional.get());
    }

    @Override
    public List<TransferHistoryResponse> getAllTransferHistories() {

        /** Rework idea for performanace
         * findAll for negotiationDealDetailRepository, dealFinancialsDetailRepository and playerGrowthDetailRepository
         * then store in cache (redis)
         * parse data and build response for getAllTransferHistoryItems()
         **/

        // findAll by playerId
        return transferHistoryRepository.findAll()
                .stream()
                .map(transferHistoryItem -> transferHistoryMapper.map(transferHistoryItem))
                .collect(Collectors.toList());
    }

    @Override
    public List<TransferHistoryResponse> getAllTransferHistoriesForPlayerId(UUID playerId) {

        /** Rework idea for performanace
         * findAll for negotiationDealDetailRepository, dealFinancialsDetailRepository and playerGrowthDetailRepository
         * then store in cache (redis)
         * parse data and build response for getAllTransferHistoryItems()
         **/

        // findAll by playerId
        return transferHistoryRepository.findAllByPlayerId(playerId)
                .stream()
                .map(transferHistoryItem -> transferHistoryMapper.map(transferHistoryItem))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public TransferHistoryResponse createTransferHistory(TransferHistoryRequest request) {

        // TODO: Check if the playerId exists before continuing once player db work is complete

        NegotiationDealDetail negotiationDealDetail = request.getNegotiationDealDetail();
        DealFinancialsDetail dealFinancialsDetail = request.getDealFinancialsDetail();
        PlayerGrowthDetail playerGrowthDetail = request.getPlayerGrowthDetail();

        TransferHistory transferHistory = TransferHistory.builder()
                .playerId(request.getPlayerId())
                .age(request.getAge())
                .seasonYear(request.getSeasonYear())
                .seasonTransferWindow(request.getSeasonTransferWindow())
                .date(request.getDate())
                .entryCreatedDateTime(LocalDateTime.now())
                .negotiationDealDetail(negotiationDealDetail)
                .dealFinancialsDetail(dealFinancialsDetail)
                .playerGrowthDetail(playerGrowthDetail)
                .build();

        negotiationDealDetail.setTransferHistory(transferHistory);
        dealFinancialsDetail.setTransferHistory(transferHistory);
        playerGrowthDetail.setTransferHistory(transferHistory);

        transferHistoryRepository.save(transferHistory);

        return transferHistoryMapper.map(transferHistory);
    }

    @Transactional
    @Override
    public TransferHistoryResponse updateTransferHistory(TransferHistoryRequest request) {

        TransferHistory transferHistory = transferHistoryRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("TransferHistory not found with id: " + request.getId()));


        // TODO: Check that trasnferhistoryId matches in all related tables (negotiationDealDetail, dealFinancialsDetail, playerGrowthDetail)
//            if ((transferHistory.getId() != negotiationDealDetail.getTransferHistory().getId()) ||
//                    (transferHistory.getId() != dealFinancialsDetail.getTransferHistory().getId()) ||
//                    (transferHistory.getId() != playerGrowthDetail.getTransferHistory().getId())) {
//                  throw new Exception();
//            }

        // TODO: Check if request and existing db record are different prior to making update call

        // TODO: Check if request body is valid

        NegotiationDealDetail negotiationDealDetail = request.getNegotiationDealDetail();
        DealFinancialsDetail dealFinancialsDetail = request.getDealFinancialsDetail();
        PlayerGrowthDetail playerGrowthDetail = request.getPlayerGrowthDetail();

        transferHistory.setId(transferHistory.getId());
        transferHistory.setPlayerId(request.getPlayerId());
        transferHistory.setAge(request.getAge());
        transferHistory.setSeasonYear(request.getSeasonYear());
        transferHistory.setSeasonTransferWindow(request.getSeasonTransferWindow());
        transferHistory.setDate(request.getDate());
        transferHistory.setEntryLastUpdatedDateTime(LocalDateTime.now());

        negotiationDealDetail.setTransferHistory(transferHistory);
        dealFinancialsDetail.setTransferHistory(transferHistory);
        playerGrowthDetail.setTransferHistory(transferHistory);

        transferHistory.setNegotiationDealDetail(negotiationDealDetail);
        transferHistory.setDealFinancialsDetail(dealFinancialsDetail);
        transferHistory.setPlayerGrowthDetail(playerGrowthDetail);

        // todo: check if transferHistoryItem is valid

        transferHistoryRepository.save(transferHistory);

        return transferHistoryMapper.map(transferHistory);
    }

    @Override
    public void deleteTransferHistory(UUID id) {
        Optional<TransferHistory> transferHistoryItemOptional = transferHistoryRepository.findById(id);

        // TODO: Throw Exception if ID doesn't exist in db

        transferHistoryRepository.delete(transferHistoryItemOptional.get());
    }
}
