package com.totaldevservices.transferhistory.repository;

import com.totaldevservices.transferhistory.model.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferHistoryRepository extends JpaRepository<TransferHistory, UUID> {
}
