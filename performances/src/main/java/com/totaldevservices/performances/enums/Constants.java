package com.totaldevservices.performances.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Constants {

    TRANSFER_HISTORY_CREATED("Transfer History Item created {}"),
    TRANSFER_HISTORY_FETCHED("Transfer History Item fetched {}"),
    TRANSFER_HISTORY_UPDATED("Transfer History Item updated {}"),
    TRANSFER_HISTORY_DELETED("Transfer History Item deleted {}");

    private final String message;

}
