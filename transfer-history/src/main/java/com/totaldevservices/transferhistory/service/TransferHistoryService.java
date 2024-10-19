package com.totaldevservices.transferhistory.service;


import com.totaldevservices.transferhistory.dto.TransferHistoryItemRequest;
import com.totaldevservices.transferhistory.dto.TransferHistoryItemResponse;

import java.util.List;
import java.util.UUID;

public interface TransferHistoryService {

    TransferHistoryItemResponse getTransferHistoryItemById(UUID id);

    List<TransferHistoryItemResponse> getAllTransferHistoryItems();

    List<TransferHistoryItemResponse> getAllTransferHistoryItemsForPlayerId(UUID playerId);

    TransferHistoryItemResponse createTransferHistoryItem(TransferHistoryItemRequest request);

    TransferHistoryItemResponse updateTransferHistoryItem(TransferHistoryItemRequest request);

    void deleteTransferHistoryItem(UUID id);
}
