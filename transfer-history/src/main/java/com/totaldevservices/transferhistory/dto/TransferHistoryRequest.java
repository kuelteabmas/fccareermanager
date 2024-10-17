package com.totaldevservices.transferhistory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.Duration;
import java.util.UUID;

@Data
public class TransferHistoryRequest {

    @Schema(name = "id", example = "25e25e41-4cb1-440d-9594-ec351726ceb5")
    UUID id;

    @Schema(name = "name", example = "Transfer History 1", requiredMode = Schema.RequiredMode.REQUIRED)
    String name;

    @Schema(name = "type", example = "Transfer History Type 1", requiredMode = Schema.RequiredMode.REQUIRED)
    String type;

    @Schema(name = "amount", example = "25", requiredMode = Schema.RequiredMode.REQUIRED)
    int amount;

    @Schema(name = "duration", example = "PT7M38S", requiredMode = Schema.RequiredMode.REQUIRED)
    Duration duration;
}
