package com.totaldevservices.transferhistory.repository;

import com.totaldevservices.transferhistory.model.DealFinancialsDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DealFinancialsDetailRepository extends JpaRepository<DealFinancialsDetail, UUID> {
}
