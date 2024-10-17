package com.totaldevservices.transferhistory.service;


import com.totaldevservices.transferhistory.dto.TransferHistoryRequest;
import com.totaldevservices.transferhistory.dto.TransferHistoryResponse;

import java.util.List;
import java.util.UUID;

public interface TransferHistoryService {

    TransferHistoryResponse getTransferHistoryItemById(UUID id);

    List<TransferHistoryResponse> getAllTransferHistoryItems();

    TransferHistoryResponse createTransferHistoryItem(TransferHistoryRequest request);

    TransferHistoryResponse updateTransferHistoryItem(TransferHistoryRequest request);

    void deleteTransferHistoryItem(UUID id);
}
