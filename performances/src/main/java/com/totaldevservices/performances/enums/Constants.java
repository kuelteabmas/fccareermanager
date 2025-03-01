package com.totaldevservices.performances.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Constants {

    MATCH_FACTS_SUMMARY_CREATED("Match Facts Summary created {}"),
    MATCH_FACTS_SUMMARY_FETCHED("Match Facts Summary fetched {}"),
    MATCH_FACTS_SUMMARY_UPDATED("Match Facts Summary updated {}"),
    MATCH_FACTS_SUMMARY_DELETED("Match Facts Summary deleted {}");

    private final String message;

}
