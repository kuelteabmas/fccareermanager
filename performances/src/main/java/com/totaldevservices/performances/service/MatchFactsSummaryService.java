package com.totaldevservices.performances.service;


import com.totaldevservices.performances.dto.MatchFactsSummaryRequest;
import com.totaldevservices.performances.dto.MatchFactsSummaryResponse;

import java.util.List;
import java.util.UUID;

public interface MatchFactsSummaryService {

    MatchFactsSummaryResponse getMatchFactsSummaryById(UUID id);

    List<MatchFactsSummaryResponse> getAllMatchFactsSummaries();

    MatchFactsSummaryResponse createMatchFactsSummary(MatchFactsSummaryRequest request);

    MatchFactsSummaryResponse updateMatchFactsSummary(MatchFactsSummaryRequest request);

    void deleteMatchFactsSummary(UUID id);
}
