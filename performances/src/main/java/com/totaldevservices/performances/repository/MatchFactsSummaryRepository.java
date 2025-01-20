package com.totaldevservices.performances.repository;

import com.totaldevservices.performances.model.MatchFactsSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchFactsSummaryRepository extends JpaRepository<MatchFactsSummary, UUID> {
}
