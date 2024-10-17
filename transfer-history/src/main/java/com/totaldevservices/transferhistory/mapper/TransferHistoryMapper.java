package com.totaldevservices.transferhistory.mapper;


import com.totaldevservices.transferhistory.dto.TransferHistoryResponse;
import com.totaldevservices.transferhistory.model.TransferHistoryItem;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TransferHistoryMapper implements Function<TransferHistoryItem, TransferHistoryResponse> {

    @Override
    public TransferHistoryResponse apply(TransferHistoryItem TransferHistoryItem) {
        return new TransferHistoryResponse(
                TransferHistoryItem.getId(),
                TransferHistoryItem.getPlayerName(),
                TransferHistoryItem.getType(),
                TransferHistoryItem.getAmount(),
                TransferHistoryItem.getDuration(),
                TransferHistoryItem.getDate()
        );


    }
}
