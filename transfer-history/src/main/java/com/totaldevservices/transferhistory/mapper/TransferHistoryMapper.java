package com.totaldevservices.transferhistory.mapper;


import com.totaldevservices.transferhistory.dto.DealFinancialsDetailResponse;
import com.totaldevservices.transferhistory.dto.NegotiationDealDetailResponse;
import com.totaldevservices.transferhistory.dto.PlayerGrowthDetailResponse;
import com.totaldevservices.transferhistory.dto.TransferHistoryResponse;
import com.totaldevservices.transferhistory.model.DealFinancialsDetail;
import com.totaldevservices.transferhistory.model.NegotiationDealDetail;
import com.totaldevservices.transferhistory.model.PlayerGrowthDetail;
import com.totaldevservices.transferhistory.model.TransferHistory;
import org.springframework.stereotype.Service;

@Service
public class TransferHistoryMapper {

    public TransferHistoryResponse map(TransferHistory transferHistory) {

        return TransferHistoryResponse.builder()
                .id(transferHistory.getId())
                .playerId(transferHistory.getPlayerId())
                .age(transferHistory.getAge())
                .seasonYear(transferHistory.getSeasonYear())
                .seasonTransferWindow(transferHistory.getSeasonTransferWindow())
                .date(transferHistory.getDate())
                .entryCreatedDateTime(transferHistory.getEntryCreatedDateTime())
                .negotiationDealDetail(map(transferHistory.getNegotiationDealDetail()))
                .dealFinancialsDetail(map(transferHistory.getDealFinancialsDetail()))
                .playerGrowthDetail(map(transferHistory.getPlayerGrowthDetail()))
                .build();
    }

    private NegotiationDealDetailResponse map(NegotiationDealDetail negotiationDealDetail) {
        return NegotiationDealDetailResponse.builder()
                .id(negotiationDealDetail.getId())
                .transferHistoryId(negotiationDealDetail.getTransferHistory().getId())
                .playerId(negotiationDealDetail.getPlayerId())
                .dealType(negotiationDealDetail.getDealType())
                .loanType(negotiationDealDetail.getLoanType())
                .parentTeam(negotiationDealDetail.getParentTeam())
                .tempTeam(negotiationDealDetail.getTempTeam())
                .contractStartDate(negotiationDealDetail.getContractStartDate())
                .contractEndDate(negotiationDealDetail.getContractEndDate())
                .playerSwappedId(negotiationDealDetail.getPlayerSwappedId())
                .build();
    }

    private DealFinancialsDetailResponse map(DealFinancialsDetail dealFinancialsDetail) {
        return DealFinancialsDetailResponse.builder()
                .id(dealFinancialsDetail.getId())
                .transferHistoryId(dealFinancialsDetail.getTransferHistory().getId())
                .playerId(dealFinancialsDetail.getPlayerId())
                .preDealWage(dealFinancialsDetail.getPreDealWage())
                .postDealWage(dealFinancialsDetail.getPostDealWage())
                .releaseClauseAmount(dealFinancialsDetail.getReleaseClauseAmount())
                .signingBonus(dealFinancialsDetail.getSigningBonus())
                .performanceBonusType(dealFinancialsDetail.getPerformanceBonusType())
                .performanceBonusCount(dealFinancialsDetail.getPerformanceBonusCount())
                .performanceBonusSum(dealFinancialsDetail.getPerformanceBonusSum())
                .transferFee(dealFinancialsDetail.getTransferFee())
                .sellonClauseAmount(dealFinancialsDetail.getSellonClauseAmount())
                .build();
    }

    private PlayerGrowthDetailResponse map(PlayerGrowthDetail playerGrowthDetail) {
        return PlayerGrowthDetailResponse.builder()
                .id(playerGrowthDetail.getId())
                .transferHistoryId(playerGrowthDetail.getTransferHistory().getId())
                .playerId(playerGrowthDetail.getPlayerId())
                .preDealPlayerStatus(playerGrowthDetail.getPreDealPlayerStatus())
                .postDealPlayerStatus(playerGrowthDetail.getPostDealPlayerStatus())
                .preDealPlayerOverrall(playerGrowthDetail.getPreDealPlayerOverrall())
                .postDealPlayerOverrall(playerGrowthDetail.getPostDealPlayerOverrall())
                .overallGrowthPercentage(playerGrowthDetail.getOverallGrowthPercentage())
                .updatedMarketValue(playerGrowthDetail.getUpdatedMarketValue())
                .build();
    }
}
