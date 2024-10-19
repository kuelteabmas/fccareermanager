package com.totaldevservices.transferhistory.service;

import com.totaldevservices.transferhistory.dto.NegotiationDealDetailRequest;
import com.totaldevservices.transferhistory.model.NegotiationDealDetail;

import java.util.UUID;

public interface NegotiationDealDetailService {
    NegotiationDealDetail getNegotiationDealDetailById(UUID id);

    NegotiationDealDetail createNegotiationDealDetail(NegotiationDealDetailRequest request);

    void deleteNegotiationDealDetail(UUID id);
}
