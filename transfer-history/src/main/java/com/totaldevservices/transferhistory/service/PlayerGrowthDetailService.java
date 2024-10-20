package com.totaldevservices.transferhistory.service;

import com.totaldevservices.transferhistory.dto.NegotiationDealDetailRequest;
import com.totaldevservices.transferhistory.dto.PlayerGrowthDetailRequest;
import com.totaldevservices.transferhistory.model.NegotiationDealDetail;
import com.totaldevservices.transferhistory.model.PlayerGrowthDetail;

import java.util.UUID;

public interface PlayerGrowthDetailService {
    PlayerGrowthDetail getPlayerGrowthDetailById(UUID id);

    PlayerGrowthDetail createPlayerGrowthDetail(PlayerGrowthDetailRequest request);

    PlayerGrowthDetail updatePlayerGrowthDetail(PlayerGrowthDetailRequest request);

    void deletePlayerGrowthDetail(UUID id);
}
