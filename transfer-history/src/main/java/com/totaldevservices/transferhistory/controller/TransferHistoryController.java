package com.totaldevservices.transferhistory.controller;

import com.totaldevservices.transferhistory.dto.TransferHistoryItemRequest;
import com.totaldevservices.transferhistory.dto.TransferHistoryItemResponse;
import com.totaldevservices.transferhistory.model.TransferHistoryItem;
import com.totaldevservices.transferhistory.service.TransferHistoryService;
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

import java.util.List;
import java.util.UUID;

import static com.totaldevservices.transferhistory.enums.Constants.DELETE_CALL;
import static com.totaldevservices.transferhistory.enums.Constants.GET_CALL;
import static com.totaldevservices.transferhistory.enums.Constants.POST_CALL;
import static com.totaldevservices.transferhistory.enums.Constants.PUT_CALL;
import static com.totaldevservices.transferhistory.enums.Constants.TRANSFER_HISTORY_CREATED;
import static com.totaldevservices.transferhistory.enums.Constants.TRANSFER_HISTORY_DELETED;
import static com.totaldevservices.transferhistory.enums.Constants.TRANSFER_HISTORY_FETCHED;
import static com.totaldevservices.transferhistory.enums.Constants.TRANSFER_HISTORY_UPDATED;

@Slf4j
@RestController
@RequestMapping("api/v1/transferhistory")
@AllArgsConstructor
public class TransferHistoryController {

    private TransferHistoryService transferHistoryService;

    @Operation(summary = "Fetch Transfer History Item by its Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Transfer History Item fetched",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TransferHistoryItem.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Transfer History Item not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<TransferHistoryItemResponse> getTransferHistoryItemById(
            @PathVariable("id") @Parameter(description = "id of Transfer History Item to be fetched") UUID id) {
        log.info(GET_CALL.getMessage());

        TransferHistoryItemResponse response = transferHistoryService.getTransferHistoryItemById(id);

        log.info(TRANSFER_HISTORY_FETCHED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Fetch all Transfer History Items")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "All Transfer History Items fetched",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TransferHistoryItem.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Transfer History Items not found",
                    content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<TransferHistoryItemResponse>> getAllTransferHistoryItems() {
        log.info(GET_CALL.getMessage());

        List<TransferHistoryItemResponse> responses = transferHistoryService.getAllTransferHistoryItems();

        log.info(TRANSFER_HISTORY_FETCHED.getMessage(), responses);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @Operation(summary = "Fetch all Transfer History Items for given Player Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "All Transfer History Items fetched",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TransferHistoryItem.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Transfer History Items not found",
                    content = @Content)
    })
    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<TransferHistoryItemResponse>> getAllTransferHistoryItemsForPlayerId(
            @PathVariable("playerId") @Parameter(description = "id of Player") UUID playerId) {
        log.info(GET_CALL.getMessage());

        List<TransferHistoryItemResponse> responses = transferHistoryService.getAllTransferHistoryItemsForPlayerId(playerId);

        log.info(TRANSFER_HISTORY_FETCHED.getMessage(), responses);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @Operation(summary = "Create a new Transfer History Item")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Transfer History Item created",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TransferHistoryItem.class))

    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Transfer History Item cannot be created",
                    content = @Content)
    })
    @PostMapping()
    public ResponseEntity<TransferHistoryItemResponse> createTransferHistoryItem(@RequestBody TransferHistoryItemRequest request) {
        log.info(POST_CALL.getMessage());

        TransferHistoryItemResponse response = transferHistoryService.createTransferHistoryItem(request);

        log.info(TRANSFER_HISTORY_CREATED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Update Transfer History Item by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Transfer History Item updated",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TransferHistoryItem.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Transfer History Item cannot be updated",
                    content = @Content)
    })
    @PutMapping()
    ResponseEntity<TransferHistoryItemResponse> updateTransferHistoryItem(@RequestBody TransferHistoryItemRequest request) {
        log.info(PUT_CALL.getMessage());

        TransferHistoryItemResponse response = transferHistoryService.updateTransferHistoryItem(request);

        log.info(TRANSFER_HISTORY_UPDATED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete Transfer History Item by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202", description = "Transfer History Item deleted",
                    content = {
                            @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TransferHistoryItem.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Transfer History Item not found; Cannot be deleted",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTransferHistoryItem(
            @PathVariable @Parameter(description = "id of Transfer History Item to be deleted") UUID id) {
        log.info(DELETE_CALL.getMessage());

        transferHistoryService.deleteTransferHistoryItem(id);

        log.info(TRANSFER_HISTORY_DELETED.getMessage());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
