package com.totaldevservices.transferhistory.repository;

import com.totaldevservices.transferhistory.model.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransferHistoryRepository extends JpaRepository<TransferHistory, UUID> {

    List<TransferHistory> findAllByPlayerId(UUID playerId);

}
