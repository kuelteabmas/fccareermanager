package com.totaldevservices.transferhistory.service;

import com.totaldevservices.transferhistory.dto.DealFinancialsDetailRequest;
import com.totaldevservices.transferhistory.model.DealFinancialsDetail;
import com.totaldevservices.transferhistory.model.DealFinancialsDetail;
import com.totaldevservices.transferhistory.repository.DealFinancialsDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DealFinancialsDetailServiceImpl implements DealFinancialsDetailService {

    private final DealFinancialsDetailRepository dealFinancialsDetailRepository;

    @Override
    public DealFinancialsDetail getDealFinancialsDetailById(UUID id) {
        Optional<DealFinancialsDetail> dealFinancialsDetailOptional =
                Optional.of(dealFinancialsDetailRepository.findById(id)
                        .orElseThrow());

        return DealFinancialsDetail.builder()
                .id(dealFinancialsDetailOptional.get().getId())
                .playerId(dealFinancialsDetailOptional.get().getPlayerId())
                .preDealWage(dealFinancialsDetailOptional.get().getPreDealWage())
                .postDealWage(dealFinancialsDetailOptional.get().getPostDealWage())
                .signingBonus(dealFinancialsDetailOptional.get().getSigningBonus())
                .performanceBonusType(dealFinancialsDetailOptional.get().getPerformanceBonusType())
                .performanceBonusCount(dealFinancialsDetailOptional.get().getPerformanceBonusCount())
                .performanceBonusSum(dealFinancialsDetailOptional.get().getPerformanceBonusSum())
                .transferFee(dealFinancialsDetailOptional.get().getTransferFee())
                .sellonClauseAmount(dealFinancialsDetailOptional.get().getSellonClauseAmount())
                .build();
    }

    @Override
    public DealFinancialsDetail createDealFinancialsDetail(DealFinancialsDetailRequest request) {

        DealFinancialsDetail dealFinancialsDetail = DealFinancialsDetail.builder()
                .playerId(request.getPlayerId())
                .preDealWage(request.getPreDealWage())
                .postDealWage(request.getPostDealWage())
                .signingBonus(request.getSigningBonus())
                .performanceBonusType(request.getPerformanceBonusType())
                .performanceBonusCount(request.getPerformanceBonusCount())
                .performanceBonusSum(request.getPerformanceBonusSum())
                .transferFee(request.getTransferFee())
                .sellonClauseAmount(request.getSellonClauseAmount())
                .build();

        // todo: check if dealFinancialsDetail is valid

        dealFinancialsDetailRepository.save(dealFinancialsDetail);

        return dealFinancialsDetail;
    }

    @Override
    public DealFinancialsDetail updateDealFinancialsDetail(DealFinancialsDetailRequest request) {
        Optional<DealFinancialsDetail> dealFinancialsDetailOptional = Optional.of(dealFinancialsDetailRepository.findById(request.getId()))
                .orElseThrow();

        DealFinancialsDetail dealFinancialsDetail = dealFinancialsDetailOptional.get();
        dealFinancialsDetail.setPlayerId(request.getPlayerId());
        dealFinancialsDetail.setPreDealWage(request.getPreDealWage());
        dealFinancialsDetail.setPostDealWage(request.getPostDealWage());
        dealFinancialsDetail.setSigningBonus(request.getSigningBonus());
        dealFinancialsDetail.setPerformanceBonusType(request.getPerformanceBonusType());
        dealFinancialsDetail.setPerformanceBonusCount(request.getPerformanceBonusCount());
        dealFinancialsDetail.setPerformanceBonusSum(request.getPerformanceBonusSum());
        dealFinancialsDetail.setTransferFee(request.getTransferFee());
        dealFinancialsDetail.setSellonClauseAmount(request.getSellonClauseAmount());

        dealFinancialsDetailRepository.save(dealFinancialsDetail);

        return dealFinancialsDetail;
    }

    @Override
    public void deleteDealFinancialsDetail(UUID id) {
        Optional<DealFinancialsDetail> dealFinancialsDetailOptional = dealFinancialsDetailRepository.findById(id);

        // TODO: Throw Exception if ID doesn't exist in db

        dealFinancialsDetailRepository.delete(dealFinancialsDetailOptional.get());
    }
}
