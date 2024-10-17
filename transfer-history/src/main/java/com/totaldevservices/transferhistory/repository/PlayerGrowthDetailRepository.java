package com.totaldevservices.transferhistory.repository;

import com.totaldevservices.transferhistory.model.PlayerGrowthDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerGrowthDetailRepository extends JpaRepository<PlayerGrowthDetail, UUID> {
}
