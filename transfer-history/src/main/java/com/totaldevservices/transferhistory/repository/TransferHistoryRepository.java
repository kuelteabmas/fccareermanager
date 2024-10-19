package com.totaldevservices.transferhistory.repository;

import com.totaldevservices.transferhistory.model.TransferHistoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransferHistoryRepository extends JpaRepository<TransferHistoryItem, UUID> {

    List<TransferHistoryItem> findAllByPlayerId(UUID playerId);

}
