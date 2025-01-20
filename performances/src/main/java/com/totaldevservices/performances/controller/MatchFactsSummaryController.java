package com.totaldevservices.performances.controller;

import com.totaldevservices.performances.dto.MatchFactsSummaryRequest;
import com.totaldevservices.performances.dto.MatchFactsSummaryResponse;
import com.totaldevservices.performances.model.MatchFactsSummary;
import com.totaldevservices.performances.service.MatchFactsSummaryService;
import com.totaldevservices.tdscommons.TDSCommons;
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

import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.DELETE_CALL;
import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.GET_CALL;
import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.POST_CALL;
import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.PUT_CALL;
import static com.totaldevservices.performances.enums.Constants.TRANSFER_HISTORY_CREATED;
import static com.totaldevservices.performances.enums.Constants.TRANSFER_HISTORY_DELETED;
import static com.totaldevservices.performances.enums.Constants.TRANSFER_HISTORY_FETCHED;
import static com.totaldevservices.performances.enums.Constants.TRANSFER_HISTORY_UPDATED;


@Slf4j
@RestController
@RequestMapping("api/v1/transferhistory")
@AllArgsConstructor
public class MatchFactsSummaryController {

    private MatchFactsSummaryService matchFactsSummaryService;

    @Operation(summary = "Fetch Transfer History Item by its Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Transfer History Item fetched",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MatchFactsSummary.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Transfer History Item not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<MatchFactsSummaryResponse> getMatchFactsSummaryItemById(
            @PathVariable("id") @Parameter(description = "id of Transfer History Item to be fetched") UUID id) {
        log.info(GET_CALL.getMessage());

        MatchFactsSummaryResponse response = matchFactsSummaryService.getMatchFactsSummaryById(id);

        log.info(TRANSFER_HISTORY_FETCHED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Fetch all Transfer History Items")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "All Transfer History Items fetched",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MatchFactsSummary.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Transfer History Items not found",
                    content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<MatchFactsSummaryResponse>> getAllMatchFactsSummaryItems() {
        log.info(GET_CALL.getMessage());

        List<MatchFactsSummaryResponse> responses = matchFactsSummaryService.getAllMatchFactsSummaries();

        log.info(TRANSFER_HISTORY_FETCHED.getMessage(), responses);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @Operation(summary = "Create a new Transfer History Item")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Transfer History Item created",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MatchFactsSummary.class))

    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Transfer History Item cannot be created",
                    content = @Content)
    })
    @PostMapping()
    public ResponseEntity<MatchFactsSummaryResponse> createMatchFactsSummaryItem(@RequestBody MatchFactsSummaryRequest request) {
        log.info(POST_CALL.getMessage());

        MatchFactsSummaryResponse response = matchFactsSummaryService.createMatchFactsSummary(request);

        log.info(TRANSFER_HISTORY_CREATED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Update Transfer History Item by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Transfer History Item updated",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MatchFactsSummary.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Transfer History Item cannot be updated",
                    content = @Content)
    })
    @PutMapping()
    ResponseEntity<MatchFactsSummaryResponse> updateMatchFactsSummaryItem(@RequestBody MatchFactsSummaryRequest request) {
        log.info(PUT_CALL.getMessage());

        MatchFactsSummaryResponse response = matchFactsSummaryService.updateMatchFactsSummary(request);

        log.info(TRANSFER_HISTORY_UPDATED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete Transfer History Item by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202", description = "Transfer History Item deleted",
                    content = {
                            @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MatchFactsSummary.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Transfer History Item not found; Cannot be deleted",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMatchFactsSummaryItem(
            @PathVariable @Parameter(description = "id of Transfer History Item to be deleted") UUID id) {
        log.info(DELETE_CALL.getMessage());

        matchFactsSummaryService.deleteMatchFactsSummary(id);

        log.info(TRANSFER_HISTORY_DELETED.getMessage());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
