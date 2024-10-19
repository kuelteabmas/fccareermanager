package com.totaldevservices.transferhistory.mapper;


import com.totaldevservices.transferhistory.dto.TransferHistoryItemResponse;
import com.totaldevservices.transferhistory.model.DealFinancialsDetail;
import com.totaldevservices.transferhistory.model.NegotiationDealDetail;
import com.totaldevservices.transferhistory.model.PlayerGrowthDetail;
import com.totaldevservices.transferhistory.model.TransferHistoryItem;
import org.springframework.stereotype.Service;

@Service
public class TransferHistoryMapper {

    public TransferHistoryItemResponse map(TransferHistoryItem transferHistoryItem,
                                           NegotiationDealDetail negotiationDealDetail,
                                           DealFinancialsDetail dealFinancialsDetail,
                                           PlayerGrowthDetail playerGrowthDetail) {

        return TransferHistoryItemResponse.builder()
                .id(transferHistoryItem.getId())
                .playerId(transferHistoryItem.getPlayerId())
                .age(transferHistoryItem.getAge())
                .seasonYear(transferHistoryItem.getSeasonYear())
                .seasonTransferWindow(transferHistoryItem.getSeasonTransferWindow())
                .date(transferHistoryItem.getDate())
                .entryCreatedDateTime(transferHistoryItem.getEntryCreatedDateTime())
                .negotiationDealDetail(negotiationDealDetail)
                .dealFinancialsDetail(dealFinancialsDetail)
                .playerGrowthDetail(playerGrowthDetail)
                .build();
    }
}
