package com.totaldevservices.transferhistory.repository;

import com.totaldevservices.transferhistory.model.NegotiationDealDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NegotiationDealDetailRepository extends JpaRepository<NegotiationDealDetail, UUID> {
}
