package com.totaldevservices.transferhistory.service;

import com.totaldevservices.transferhistory.dto.DealFinancialsDetailRequest;
import com.totaldevservices.transferhistory.model.DealFinancialsDetail;

import java.util.UUID;

public interface DealFinancialsDetailService {
    DealFinancialsDetail getDealFinancialsDetailById(UUID id);

    DealFinancialsDetail createDealFinancialsDetail(DealFinancialsDetailRequest request);

    void deleteDealFinancialsDetail(UUID id);
}
