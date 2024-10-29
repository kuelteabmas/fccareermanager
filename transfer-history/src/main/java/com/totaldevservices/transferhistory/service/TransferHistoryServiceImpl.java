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

    @Override
    public TransferHistoryResponse updateTransferHistory(TransferHistoryRequest request) {
        return null;
    }

    @Override
    public void deleteTransferHistory(UUID id) {
        Optional<TransferHistory> transferHistoryItemOptional = transferHistoryRepository.findById(id);

        // TODO: Throw Exception if ID doesn't exist in db

        transferHistoryRepository.delete(transferHistoryItemOptional.get());
    }
}
