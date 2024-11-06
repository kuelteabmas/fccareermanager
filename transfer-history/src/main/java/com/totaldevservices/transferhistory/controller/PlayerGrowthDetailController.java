package com.totaldevservices.transferhistory.controller;

import com.totaldevservices.transferhistory.dto.PlayerGrowthDetailRequest;
import com.totaldevservices.transferhistory.dto.PlayerGrowthDetailRequest;
import com.totaldevservices.transferhistory.model.PlayerGrowthDetail;
import com.totaldevservices.transferhistory.model.PlayerGrowthDetail;
import com.totaldevservices.transferhistory.service.PlayerGrowthDetailService;
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

import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.DELETE_CALL;
import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.GET_CALL;
import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.POST_CALL;
import static com.totaldevservices.tdscommons.enums.TDSCommonsConstants.PUT_CALL;
import static com.totaldevservices.transferhistory.enums.Constants.PLAYER_GROWTH_DETAIL_CREATED;
import static com.totaldevservices.transferhistory.enums.Constants.PLAYER_GROWTH_DETAIL_DELETED;
import static com.totaldevservices.transferhistory.enums.Constants.PLAYER_GROWTH_DETAIL_FETCHED;
import static com.totaldevservices.transferhistory.enums.Constants.PLAYER_GROWTH_DETAIL_UPDATED;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/player-growth-detail")
public class PlayerGrowthDetailController {

    private PlayerGrowthDetailService playerGrowthDetailService;

    @Operation(summary = "Fetch Player Growth Detail by its Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Player Growth Detail fetched",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PlayerGrowthDetail.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Player Growth Detail not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<PlayerGrowthDetail> getPlayerGrowthDetailById(
            @PathVariable("id") @Parameter(description = "id of Player Growth Detail to be fetched") UUID id) {
        log.info(GET_CALL.getMessage());

        PlayerGrowthDetail response = playerGrowthDetailService.getPlayerGrowthDetailById(id);

        log.info(PLAYER_GROWTH_DETAIL_FETCHED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @Operation(summary = "Create a new Player Growth Detail")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Player Growth Detail created",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PlayerGrowthDetail.class))

                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Player Growth Detail cannot be created",
                    content = @Content)
    })
    @PostMapping()
    public ResponseEntity<PlayerGrowthDetail> createPlayerGrowthDetail(@RequestBody PlayerGrowthDetailRequest request) {
        log.info(POST_CALL.getMessage());

        PlayerGrowthDetail response = playerGrowthDetailService.createPlayerGrowthDetail(request);

        log.info(PLAYER_GROWTH_DETAIL_CREATED.getMessage(), response);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Update Player Growth Detail by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Player Growth Detail updated",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PlayerGrowthDetail.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Player Growth Detail cannot be updated",
                    content = @Content)
    })
    @PutMapping()
    ResponseEntity<PlayerGrowthDetail> updatePlayerGrowthDetail(@RequestBody PlayerGrowthDetailRequest request) {
        log.info(PUT_CALL.getMessage());

        PlayerGrowthDetail response = playerGrowthDetailService.updatePlayerGrowthDetail(request);

        log.info(PLAYER_GROWTH_DETAIL_UPDATED.getMessage(), response);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete Player Growth Detail by its id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202", description = "Player Growth Detail deleted",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PlayerGrowthDetail.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Player Growth Detail not found; Cannot be deleted",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePlayerGrowthDetail(
            @PathVariable("id") @Parameter(description = "id of Player Growth Detail to be deleted") UUID id) {
        log.info(DELETE_CALL.getMessage());

        playerGrowthDetailService.deletePlayerGrowthDetail(id);

        log.info(PLAYER_GROWTH_DETAIL_DELETED.getMessage());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
