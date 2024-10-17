package com.totaldevservices.transferhistory.dto;

import com.totaldevservices.transferhistory.model.NegotiationDealDetails;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
public class TransferHistoryResponse {

    private UUID id;

    private String playerName;
    private String fromTeam;
    private String toTeam;
    private String loanType;
    private int loanDurationInMonths;
    private String transferType;
    private double wage;
    private double releaseClauseAmount;
    private double bonus;
    private double signonBonus;
    private double bonusType;
    private double saleAmount;
    private String playerStatus;
    private int playerMarketValue;
    private String playerRole;
    private int contractLength;
    private int preLoanPlayerOverrall;
    private int postLoanPlayerOverrall;
    private int age;
    private double growthPercentage;
    private int seasonYear;
    private String seasonTransferWindow;
    private LocalDate date;
    private LocalDateTime entryCreated;

    private NegotiationDealDetails negotiationDealDetails;
}


