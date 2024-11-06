package com.totaldevservices.tdscommons.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TDSCommonsConstants {

    GET_CALL("Starting GET call"),
    POST_CALL("Starting POST call"),
    PUT_CALL("Starting PUT call"),
    DELETE_CALL("Starting DELETE call");

    private final String message;

}
