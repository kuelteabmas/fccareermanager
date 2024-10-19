package com.totaldevservices.transferhistory.service;

import com.totaldevservices.transferhistory.dto.TransferHistoryItemRequest;
import com.totaldevservices.transferhistory.dto.TransferHistoryItemResponse;
import com.totaldevservices.transferhistory.mapper.TransferHistoryMapper;
import com.totaldevservices.transferhistory.model.DealFinancialsDetail;
import com.totaldevservices.transferhistory.model.NegotiationDealDetail;
import com.totaldevservices.transferhistory.model.PlayerGrowthDetail;
import com.totaldevservices.transferhistory.model.TransferHistoryItem;
import com.totaldevservices.transferhistory.repository.DealFinancialsDetailRepository;
import com.totaldevservices.transferhistory.repository.NegotiationDealDetailRepository;
import com.totaldevservices.transferhistory.repository.PlayerGrowthDetailRepository;
import com.totaldevservices.transferhistory.repository.TransferHistoryRepository;
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

    private TransferHistoryMapper transferHistoryMapper;

    @Override
    public TransferHistoryItemResponse getTransferHistoryItemById(UUID transferHistoryItemId) {
        Optional<TransferHistoryItem> transferHistoryItemOptional =
                Optional.of(transferHistoryRepository.findById(transferHistoryItemId)
                .orElseThrow());

        TransferHistoryItem transferHistoryItem = transferHistoryItemOptional.get();

        Optional<NegotiationDealDetail> negotiationDealDetailOptional =
                Optional.of(negotiationDealDetailRepository.findById(transferHistoryItem.getNegotiationDealDetailsId())
                        .orElseThrow());

        Optional<DealFinancialsDetail> dealFinancialsDetailOptional =
                Optional.of(dealFinancialsDetailRepository.findById(transferHistoryItem.getDealFinancialsDetailsId())
                        .orElseThrow());

        Optional<PlayerGrowthDetail> playerGrowthDetailOptional =
                Optional.of(playerGrowthDetailRepository.findById(transferHistoryItem.getPlayerGrowthDetailsId())
                        .orElseThrow());

        return TransferHistoryItemResponse.builder()
                .id(transferHistoryItemId)
                .playerId(transferHistoryItem.getPlayerId())
                .age(transferHistoryItem.getAge())
                .seasonYear(transferHistoryItem.getSeasonYear())
                .seasonTransferWindow(transferHistoryItem.getSeasonTransferWindow())
                .date(transferHistoryItem.getDate())
                .entryCreatedDateTime(transferHistoryItem.getEntryCreatedDateTime())
                .negotiationDealDetail(negotiationDealDetailOptional.get())
                .dealFinancialsDetail(dealFinancialsDetailOptional.get())
                .playerGrowthDetail(playerGrowthDetailOptional.get())
                .build();
    }

    @Override
    public List<TransferHistoryItemResponse> getAllTransferHistoryItems() {

        /** Rework idea for performanace
         * findAll for negotiationDealDetailRepository, dealFinancialsDetailRepository and playerGrowthDetailRepository
         * then store in cache (redis)
         * parse data and build response for getAllTransferHistoryItems()
         **/

        // findAll by playerId
        return transferHistoryRepository.findAll()
                .stream()
                .map(
                        transferHistoryItem -> transferHistoryMapper.map(transferHistoryItem,
                                negotiationDealDetailRepository.findById(transferHistoryItem.getNegotiationDealDetailsId()).get(),
                                dealFinancialsDetailRepository.findById(transferHistoryItem.getDealFinancialsDetailsId()).get(),
                                playerGrowthDetailRepository.findById(transferHistoryItem.getPlayerGrowthDetailsId()).get()
                        )
                )
                .collect(Collectors.toList());
    }

    @Override
    public TransferHistoryItemResponse createTransferHistoryItem(TransferHistoryItemRequest request) {

        UUID playerId = request.getPlayerId();

        // TODO: Check if the playerId exists before continuing

        NegotiationDealDetail negotiationDealDetail = negotiationDealDetailRepository.findById(request.getNegotiationDealDetailsId()).get();
        DealFinancialsDetail dealFinancialsDetail = dealFinancialsDetailRepository.findById(request.getDealFinancialsDetailsId()).get();
        PlayerGrowthDetail playerGrowthDetail = playerGrowthDetailRepository.findById(request.getPlayerGrowthDetailsId()).get();
        // TODO: Check that playerId matches in all related tables (negotiationDealDetail, dealFinancialsDetail, playerGrowthDetail)
//        UUID playerIdFromNegotiationDealDetail = negotiationDealDetail.getPlayerId();
//        UUID playerIdFromDealFinancialsDetail = dealFinancialsDetail.getPlayerId();
//        UUID playerIdFromPlayerGrowthDetail = playerGrowthDetail.getPlayerId();
//
//        if (playerId != playerIdFromNegotiationDealDetail || playerId != playerIdFromDealFinancialsDetail || playerId != playerIdFromPlayerGrowthDetail) {
//            // throw new Exception();
//        }

        TransferHistoryItem transferHistoryItem = TransferHistoryItem.builder()
                .playerId(request.getPlayerId())
                .age(request.getAge())
                .seasonYear(request.getSeasonYear())
                .seasonTransferWindow(request.getSeasonTransferWindow())
                .date(request.getDate())
                .entryCreatedDateTime(LocalDateTime.now())
                .negotiationDealDetailsId(request.getNegotiationDealDetailsId())
                .dealFinancialsDetailsId(request.getDealFinancialsDetailsId())
                .playerGrowthDetailsId(request.getPlayerGrowthDetailsId())
                .build();

        // todo: check if TransferHistoryitem is valid

        transferHistoryRepository.save(transferHistoryItem);

        return transferHistoryMapper.map(transferHistoryItem, negotiationDealDetail, dealFinancialsDetail, playerGrowthDetail);
    }

    @Override
    public TransferHistoryItemResponse updateTransferHistoryItem(TransferHistoryItemRequest request) {
        return null;
    }

    @Override
    public void deleteTransferHistoryItem(UUID id) {
        Optional<TransferHistoryItem> transferHistoryItemOptional = transferHistoryRepository.findById(id);

        // TODO: Throw Exception if ID doesn't exist in db

        transferHistoryRepository.delete(transferHistoryItemOptional.get());
    }
}
