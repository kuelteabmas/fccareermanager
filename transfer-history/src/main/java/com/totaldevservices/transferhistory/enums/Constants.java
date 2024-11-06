package com.totaldevservices.transferhistory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Constants {

    APPEARANCES("Appearances"),
    GOALS("Goals"),
    CLEAN_SHEETS("Clean Sheets"),

    NEGOTIATION_DEAL_DETAIL_CREATED("Negotiation Deal Detail created {}"),
    NEGOTIATION_DEAL_DETAIL_FETCHED("Negotiation Deal Detail fetched {}"),
    NEGOTIATION_DEAL_DETAIL_UPDATED("Negotiation Deal Detail updated {}"),
    NEGOTIATION_DEAL_DETAIL_DELETED("Negotiation Deal Detail deleted {}"),

    DEAL_FINANCIALS_DETAIL_CREATED("Deal Financials Detail created {}"),
    DEAL_FINANCIALS_DETAIL_FETCHED("Deal Financials Detail fetched {}"),
    DEAL_FINANCIALS_DETAIL_UPDATED("Deal Financials Detail updated {}"),
    DEAL_FINANCIALS_DETAIL_DELETED("Deal Financials Detail deleted {}"),

    PLAYER_GROWTH_DETAIL_CREATED("Player Growth Detail created {}"),
    PLAYER_GROWTH_DETAIL_FETCHED("Player Growth Detail fetched {}"),
    PLAYER_GROWTH_DETAIL_UPDATED("Player Growth Detail updated {}"),
    PLAYER_GROWTH_DETAIL_DELETED("Player Growth Detail deleted {}"),

    TRANSFER_HISTORY_CREATED("Transfer History Item created {}"),
    TRANSFER_HISTORY_FETCHED("Transfer History Item fetched {}"),
    TRANSFER_HISTORY_UPDATED("Transfer History Item updated {}"),
    TRANSFER_HISTORY_DELETED("Transfer History Item deleted {}");

    private final String message;

}
