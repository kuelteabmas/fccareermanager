package com.totaldevservices.performances.controller;

import com.totaldevservices.performances.dto.MatchFactsSummaryRequest;
import com.totaldevservices.performances.dto.MatchFactsSummaryResponse;
import com.totaldevservices.performances.model.MatchFactsSummary;
import com.totaldevservices.performances.service.MatchFactsSummaryService;
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
import static com.totaldevservices.performances.enums.Constants.MATCH_FACTS_SUMMARY_CREATED;
import static com.totaldevservices.performances.enums.Constants.MATCH_FACTS_SUMMARY_DELETED;
import static com.totaldevservices.performances.enums.Constants.MATCH_FACTS_SUMMARY_FETCHED;
import static com.totaldevservices.performances.enums.Constants.MATCH_FACTS_SUMMARY_UPDATED;


@Slf4j
@RestController
@RequestMapping("api/v1/transferhistory")
@AllArgsConstructor
public class MatchFactsSummaryController {

    private MatchFactsSummaryService matchFactsSummaryService;

    @Operation(summary = "Fetch Match Facts Summary by its Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Match Facts Summary fetched",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MatchFactsSummary.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Match Facts Summary not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<MatchFactsSummaryResponse> getMatchFactsSummaryById(
            @PathVariable("id") @Parameter(description = "id of Match Facts Summary to be fetched") UUID id) {
        log.info(GET_CALL.getMessage());

        MatchFactsSummaryResponse response = matchFactsSummaryService.getMatchFactsSummaryById(id);

        log.info(MATCH_FACTS_SUMMARY_FETCHED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Fetch all Match Facts Summarys")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "All Match Facts Summaries fetched",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MatchFactsSummary.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Match Facts Summaries not found",
                    content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<MatchFactsSummaryResponse>> getAllMatchFactsSummaries() {
        log.info(GET_CALL.getMessage());

        List<MatchFactsSummaryResponse> responses = matchFactsSummaryService.getAllMatchFactsSummaries();

        log.info(MATCH_FACTS_SUMMARY_FETCHED.getMessage(), responses);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @Operation(summary = "Create a new Match Facts Summary")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Match Facts Summary created",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MatchFactsSummary.class))

    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Match Facts Summary cannot be created",
                    content = @Content)
    })
    @PostMapping()
    public ResponseEntity<MatchFactsSummaryResponse> createMatchFactsSummary(@RequestBody MatchFactsSummaryRequest request) {
        log.info(POST_CALL.getMessage());

        MatchFactsSummaryResponse response = matchFactsSummaryService.createMatchFactsSummary(request);

        log.info(MATCH_FACTS_SUMMARY_CREATED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Update Match Facts Summary by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Match Facts Summary updated",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MatchFactsSummary.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Match Facts Summary cannot be updated",
                    content = @Content)
    })
    @PutMapping()
    ResponseEntity<MatchFactsSummaryResponse> updateMatchFactsSummary(@RequestBody MatchFactsSummaryRequest request) {
        log.info(PUT_CALL.getMessage());

        MatchFactsSummaryResponse response = matchFactsSummaryService.updateMatchFactsSummary(request);

        log.info(MATCH_FACTS_SUMMARY_UPDATED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete Match Facts Summary by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202", description = "Match Facts Summary deleted",
                    content = {
                            @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MatchFactsSummary.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Match Facts Summary not found; Cannot be deleted",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMatchFactsSummary(
            @PathVariable @Parameter(description = "id of Match Facts Summary to be deleted") UUID id) {
        log.info(DELETE_CALL.getMessage());

        matchFactsSummaryService.deleteMatchFactsSummary(id);

        log.info(MATCH_FACTS_SUMMARY_DELETED.getMessage());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
