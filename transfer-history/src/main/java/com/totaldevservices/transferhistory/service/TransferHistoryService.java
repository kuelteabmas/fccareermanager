package com.totaldevservices.transferhistory.service;


import com.totaldevservices.transferhistory.dto.TransferHistoryRequest;
import com.totaldevservices.transferhistory.dto.TransferHistoryResponse;

import java.util.List;
import java.util.UUID;

public interface TransferHistoryService {

    TransferHistoryResponse getTransferHistoryById(UUID id);

    List<TransferHistoryResponse> getAllTransferHistories();

    List<TransferHistoryResponse> getAllTransferHistoryItemsForPlayerId(UUID playerId);

    TransferHistoryResponse createTransferHistory(TransferHistoryRequest request);

    TransferHistoryResponse updateTransferHistory(TransferHistoryRequest request);

    void deleteTransferHistory(UUID id);
}
