package com.totaldevservices.transferhistory.service;

import com.totaldevservices.transferhistory.dto.DealFinancialsDetailRequest;
import com.totaldevservices.transferhistory.dto.NegotiationDealDetailRequest;
import com.totaldevservices.transferhistory.model.DealFinancialsDetail;
import com.totaldevservices.transferhistory.model.NegotiationDealDetail;

import java.util.UUID;

public interface DealFinancialsDetailService {
    DealFinancialsDetail getDealFinancialsDetailById(UUID id);

    DealFinancialsDetail createDealFinancialsDetail(DealFinancialsDetailRequest request);

    DealFinancialsDetail updateDealFinancialsDetail(DealFinancialsDetailRequest request);

    void deleteDealFinancialsDetail(UUID id);
}
