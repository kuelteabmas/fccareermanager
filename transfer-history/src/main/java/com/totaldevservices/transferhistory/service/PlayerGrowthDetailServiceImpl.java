package com.totaldevservices.transferhistory.service;

import com.totaldevservices.transferhistory.dto.PlayerGrowthDetailRequest;
import com.totaldevservices.transferhistory.model.PlayerGrowthDetail;
import com.totaldevservices.transferhistory.repository.PlayerGrowthDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlayerGrowthDetailServiceImpl implements PlayerGrowthDetailService {

    private final PlayerGrowthDetailRepository playerGrowthDetailRepository;

    @Override
    public PlayerGrowthDetail getPlayerGrowthDetailById(UUID id) {
        Optional<PlayerGrowthDetail> playerGrowthDetailOptional =
                Optional.of(playerGrowthDetailRepository.findById(id)
                        .orElseThrow());

        return PlayerGrowthDetail.builder()
                .id(playerGrowthDetailOptional.get().getId())
                .playerId(playerGrowthDetailOptional.get().getPlayerId())
                .preDealPlayerStatus(playerGrowthDetailOptional.get().getPreDealPlayerStatus())
                .postDealPlayerStatus(playerGrowthDetailOptional.get().getPostDealPlayerStatus())
                .preDealPlayerOverrall(playerGrowthDetailOptional.get().getPreDealPlayerOverrall())
                .postDealPlayerOverrall(playerGrowthDetailOptional.get().getPostDealPlayerOverrall())
                .overallGrowthPercentage(playerGrowthDetailOptional.get().getOverallGrowthPercentage())
                .updatedMarketValue(playerGrowthDetailOptional.get().getUpdatedMarketValue())
                .build();
    }

    @Override
    public PlayerGrowthDetail createPlayerGrowthDetail(PlayerGrowthDetailRequest request) {

        PlayerGrowthDetail playerGrowthDetail = PlayerGrowthDetail.builder()
                .playerId(request.getPlayerId())
                .preDealPlayerStatus(request.getPreDealPlayerStatus())
                .postDealPlayerStatus(request.getPostDealPlayerStatus())
                .preDealPlayerOverrall(request.getPreDealPlayerOverrall())
                .postDealPlayerOverrall(request.getPostDealPlayerOverrall())
                .overallGrowthPercentage(request.getOverallGrowthPercentage())
                .updatedMarketValue(request.getUpdatedMarketValue())
                .build();

        // todo: check if playerGrowthDetail is valid

        playerGrowthDetailRepository.save(playerGrowthDetail);

        return playerGrowthDetail;
    }

    @Override
    public void deletePlayerGrowthDetail(UUID id) {
        Optional<PlayerGrowthDetail> playerGrowthDetailOptional = playerGrowthDetailRepository.findById(id);

        // TODO: Throw Exception if ID doesn't exist in db

        playerGrowthDetailRepository.delete(playerGrowthDetailOptional.get());
    }
}
