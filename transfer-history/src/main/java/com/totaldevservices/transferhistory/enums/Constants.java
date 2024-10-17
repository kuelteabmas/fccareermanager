package com.totaldevservices.transferhistory.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Constants {
    
    TRANSFER_HISTORY_CREATED("Transfer History Item created {}"),
    TRANSFER_HISTORY_FETCHED("Transfer History Item fetched {}"),
    TRANSFER_HISTORY_UPDATED("Transfer History Item updated {}"),
    TRANSFER_HISTORY_DELETED("Transfer History Item deleted {}"),

    GET_CALL("Starting GET call"),
    POST_CALL("Starting POST call"),
    PUT_CALL("Starting PUT call"),
    DELETE_CALL("Starting DELETE call");

    private final String message;

}
