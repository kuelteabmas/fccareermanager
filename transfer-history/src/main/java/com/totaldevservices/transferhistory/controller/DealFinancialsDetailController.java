package com.totaldevservices.transferhistory.controller;

import com.totaldevservices.transferhistory.dto.DealFinancialsDetailRequest;
import com.totaldevservices.transferhistory.model.DealFinancialsDetail;
import com.totaldevservices.transferhistory.service.DealFinancialsDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.totaldevservices.transferhistory.enums.Constants.DELETE_CALL;
import static com.totaldevservices.transferhistory.enums.Constants.GET_CALL;
import static com.totaldevservices.transferhistory.enums.Constants.DEAL_FINANCIALS_DETAIL_CREATED;
import static com.totaldevservices.transferhistory.enums.Constants.DEAL_FINANCIALS_DETAIL_DELETED;
import static com.totaldevservices.transferhistory.enums.Constants.DEAL_FINANCIALS_DETAIL_FETCHED;
import static com.totaldevservices.transferhistory.enums.Constants.POST_CALL;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/deal-financials-detail")
public class DealFinancialsDetailController {

    private DealFinancialsDetailService dealFinancialsDetailService;

    @Operation(summary = "Fetch Deal Financials Detail by its Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Deal Financials Detail fetched",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DealFinancialsDetail.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Deal Financials Detail not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<DealFinancialsDetail> getDealFinancialsDetailById(
            @PathVariable("id") @Parameter(description = "id of Deal Financials Detail to be fetched") UUID id) {
        log.info(GET_CALL.getMessage());

        DealFinancialsDetail response = dealFinancialsDetailService.getDealFinancialsDetailById(id);

        log.info(DEAL_FINANCIALS_DETAIL_FETCHED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @Operation(summary = "Create a new Deal Financials Detail")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Deal Financials Detail created",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DealFinancialsDetail.class))

                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Deal Financials Detail cannot be created",
                    content = @Content)
    })
    @PostMapping()
    public ResponseEntity<DealFinancialsDetail> createDealFinancialsDetail(@RequestBody DealFinancialsDetailRequest request) {
        log.info(POST_CALL.getMessage());

        DealFinancialsDetail response = dealFinancialsDetailService.createDealFinancialsDetail(request);

        log.info(DEAL_FINANCIALS_DETAIL_CREATED.getMessage(), response);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete Deal Financials Detail by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202", description = "Deal Financials Detail deleted",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DealFinancialsDetail.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Deal Financials Detail not found; Cannot be deleted",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteDealFinancialsDetail(
            @PathVariable("id") @Parameter(description = "id of Deal Financials Detail to be deleted") UUID id) {
        log.info(DELETE_CALL.getMessage());

        dealFinancialsDetailService.deleteDealFinancialsDetail(id);

        log.info(DEAL_FINANCIALS_DETAIL_DELETED.getMessage());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
