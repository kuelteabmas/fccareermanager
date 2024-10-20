package com.totaldevservices.transferhistory.service;

import com.totaldevservices.transferhistory.dto.NegotiationDealDetailRequest;
import com.totaldevservices.transferhistory.model.NegotiationDealDetail;
import com.totaldevservices.transferhistory.repository.NegotiationDealDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NegotiationDealDetailServiceImpl implements NegotiationDealDetailService {

    private final NegotiationDealDetailRepository negotiationDealDetailRepository;

    @Override
    public NegotiationDealDetail getNegotiationDealDetailById(UUID id) {
        Optional<NegotiationDealDetail> negotiationDealDetailOptional =
                Optional.of(negotiationDealDetailRepository.findById(id)
                        .orElseThrow());

        return NegotiationDealDetail.builder()
                .id(negotiationDealDetailOptional.get().getId())
                .playerId(negotiationDealDetailOptional.get().getPlayerId())
                .dealType(negotiationDealDetailOptional.get().getDealType())
                .loanType(negotiationDealDetailOptional.get().getLoanType())
                .parentTeam(negotiationDealDetailOptional.get().getParentTeam())
                .tempTeam(negotiationDealDetailOptional.get().getTempTeam())
                .loanDurationInMonths(negotiationDealDetailOptional.get().getLoanDurationInMonths())
                .contractStartDate(negotiationDealDetailOptional.get().getContractStartDate())
                .contractEndDate(negotiationDealDetailOptional.get().getContractEndDate())
                .playerSwappedId(negotiationDealDetailOptional.get().getPlayerSwappedId())
                .build();
    }

    @Override
    public NegotiationDealDetail createNegotiationDealDetail(NegotiationDealDetailRequest request) {

        NegotiationDealDetail negotiationDealDetail = NegotiationDealDetail.builder()
                .playerId(request.getPlayerId())
                .dealType(request.getDealType())
                .loanType(request.getLoanType())
                .parentTeam(request.getParentTeam())
                .tempTeam(request.getTempTeam())
                .loanDurationInMonths(request.getLoanDurationInMonths())
                .contractStartDate(request.getContractStartDate())
                .contractEndDate(request.getContractEndDate())
                .playerSwappedId(request.getPlayerSwappedId())
                .build();

        // todo: check if negotiationDealDetail is valid

        negotiationDealDetailRepository.save(negotiationDealDetail);

        return negotiationDealDetail;
    }

    @Override
    public NegotiationDealDetail updateNegotiationDealDetail(NegotiationDealDetailRequest request) {
        Optional<NegotiationDealDetail> negotiationDealDetailOptional = Optional.of(negotiationDealDetailRepository.findById(request.getId()))
                .orElseThrow();

        NegotiationDealDetail negotiationDealDetail = negotiationDealDetailOptional.get();
        negotiationDealDetail.setPlayerId(request.getPlayerId());
        negotiationDealDetail.setDealType(request.getDealType());
        negotiationDealDetail.setLoanType(request.getLoanType());
        negotiationDealDetail.setParentTeam(request.getParentTeam());
        negotiationDealDetail.setTempTeam(request.getTempTeam());
        negotiationDealDetail.setLoanDurationInMonths(request.getLoanDurationInMonths());
        negotiationDealDetail.setContractStartDate(request.getContractStartDate());
        negotiationDealDetail.setContractEndDate(request.getContractEndDate());
        negotiationDealDetail.setPlayerSwappedId(request.getPlayerSwappedId());

        negotiationDealDetailRepository.save(negotiationDealDetail);

        return negotiationDealDetail;
    }

    @Override
    public void deleteNegotiationDealDetail(UUID id) {
        Optional<NegotiationDealDetail> negotiationDealDetailOptional = negotiationDealDetailRepository.findById(id);

        // TODO: Throw Exception if ID doesn't exist in db

        negotiationDealDetailRepository.delete(negotiationDealDetailOptional.get());
    }
}
