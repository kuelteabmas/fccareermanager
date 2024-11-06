package com.totaldevservices.transferhistory.controller;

import com.totaldevservices.transferhistory.dto.NegotiationDealDetailRequest;
import com.totaldevservices.transferhistory.model.NegotiationDealDetail;
import com.totaldevservices.transferhistory.service.NegotiationDealDetailService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.GET_CALL;
import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.POST_CALL;
import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.PUT_CALL;
import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.DELETE_CALL;
import static com.totaldevservices.transferhistory.enums.Constants.NEGOTIATION_DEAL_DETAIL_FETCHED;
import static com.totaldevservices.transferhistory.enums.Constants.NEGOTIATION_DEAL_DETAIL_CREATED;
import static com.totaldevservices.transferhistory.enums.Constants.NEGOTIATION_DEAL_DETAIL_UPDATED;
import static com.totaldevservices.transferhistory.enums.Constants.NEGOTIATION_DEAL_DETAIL_DELETED;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/negotiation-deal-detail")
public class NegotiationDealDetailController {

    private NegotiationDealDetailService negotiationDealDetailService;

    @Operation(summary = "Fetch Negotiation Deal Detail by its Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Negotiation Deal Detail fetched",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = NegotiationDealDetail.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Negotiation Deal Detail not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<NegotiationDealDetail> getNegotiationDealDetailById(
            @PathVariable("id") @Parameter(description = "id of Negotiation Deal Detail to be fetched") UUID id) {
        log.info(GET_CALL.getMessage());

        NegotiationDealDetail response = negotiationDealDetailService.getNegotiationDealDetailById(id);

        log.info(NEGOTIATION_DEAL_DETAIL_FETCHED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @Operation(summary = "Create a new Negotiation Deal Detail")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Negotiation Deal Detail created",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = NegotiationDealDetail.class))

                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Negotiation Deal Detail cannot be created",
                    content = @Content)
    })
    @PostMapping()
    public ResponseEntity<NegotiationDealDetail> createNegotiationDealDetail(@RequestBody NegotiationDealDetailRequest request) {
        log.info(POST_CALL.getMessage());

        NegotiationDealDetail response = negotiationDealDetailService.createNegotiationDealDetail(request);

        log.info(NEGOTIATION_DEAL_DETAIL_CREATED.getMessage(), response);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Update Negotiation Deal Detail by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Negotiation Deal Detail updated",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = NegotiationDealDetail.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Negotiation Deal Detail cannot be updated",
                    content = @Content)
    })
    @PutMapping()
    ResponseEntity<NegotiationDealDetail> updateNegotiationDealDetail(@RequestBody NegotiationDealDetailRequest request) {
        log.info(PUT_CALL.getMessage());

        NegotiationDealDetail response = negotiationDealDetailService.updateNegotiationDealDetail(request);

        log.info(NEGOTIATION_DEAL_DETAIL_UPDATED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    
    @Operation(summary = "Delete Negotiation Deal Detail by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202", description = "Negotiation Deal Detail deleted",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = NegotiationDealDetail.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Negotiation Deal Detail not found; Cannot be deleted",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteNegotiationDealDetail(
            @PathVariable("id") @Parameter(description = "id of Negotiation Deal Detail to be deleted") UUID id) {
        log.info(DELETE_CALL.getMessage());

        negotiationDealDetailService.deleteNegotiationDealDetail(id);

        log.info(NEGOTIATION_DEAL_DETAIL_DELETED.getMessage());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
