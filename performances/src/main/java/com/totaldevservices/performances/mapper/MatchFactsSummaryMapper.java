package com.totaldevservices.performances.mapper;

import com.totaldevservices.performances.dto.MatchFactsSummaryResponse;
import com.totaldevservices.performances.model.MatchFactsSummary;
import org.springframework.stereotype.Service;

@Service
public class MatchFactsSummaryMapper {

    public MatchFactsSummaryResponse map(MatchFactsSummary matchFactsSummary) {

        return MatchFactsSummaryResponse.builder()
                .id(matchFactsSummary.getId())
                .playerId(matchFactsSummary.getPlayerId())
                .seasonTransferWindow(matchFactsSummary.getSeasonTransferWindow())
                .date(matchFactsSummary.getDate())
                .entryCreatedDateTime(matchFactsSummary.getEntryCreatedDateTime())
                .build();
    }

}
