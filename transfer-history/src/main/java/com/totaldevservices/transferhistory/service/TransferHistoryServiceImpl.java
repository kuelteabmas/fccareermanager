package com.totaldevservices.transferhistory.service;

import com.totaldevservices.transferhistory.dto.TransferHistoryRequest;
import com.totaldevservices.transferhistory.dto.TransferHistoryResponse;
import com.totaldevservices.transferhistory.mapper.TransferHistoryMapper;
import com.totaldevservices.transferhistory.model.TransferHistoryItem;
import com.totaldevservices.transferhistory.repository.TransferHistoryRepository;
import lombok.AllArgsConstructor;
import org.gradle.internal.impldep.org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransferHistoryServiceImpl implements TransferHistoryService {

    private TransferHistoryRepository TransferHistoryRepository;
    private TransferHistoryMapper TransferHistoryMapper;

    @Override
    public TransferHistoryResponse getTransferHistoryItemById(UUID id) {
        Optional<TransferHistoryItem> TransferHistoryItemOptional =
                Optional.of(TransferHistoryRepository.findById(id)
                .orElseThrow());

        // TODO: Throw Exception if ID doesn't exist in db

        TransferHistoryResponse TransferHistoryResponse = TransferHistoryMapper.apply(TransferHistoryItemOptional.get());
        return TransferHistoryResponse;
    }

    @Override
    public List<TransferHistoryResponse> getAllTransferHistoryItems() {
        List<TransferHistoryResponse> TransferHistoryResponses = TransferHistoryRepository.findAll()
                .stream()
                .map(TransferHistoryMapper)
                .collect(Collectors.toList());
        return TransferHistoryResponses;
    }

    @Override
    public TransferHistoryResponse createTransferHistoryItem(TransferHistoryRequest request) {
        TransferHistoryItem TransferHistoryItem = null;
        TransferHistoryItem = TransferHistoryItem.builder()
                .playerName(request.getName())
                .type(request.getType())
                .amount(request.getAmount())
                .duration(request.getDuration())
                .date(LocalDateTime.now())
                .build();

        // todo: check if TransferHistoryitem is valid

        TransferHistoryRepository.save(TransferHistoryItem);


        TransferHistoryResponse TransferHistoryResponse = TransferHistoryMapper.apply(TransferHistoryItem);
        return TransferHistoryResponse;
    }

    @Override
    public TransferHistoryResponse updateTransferHistoryItem(TransferHistoryRequest request) {
        Optional<TransferHistoryItem> TransferHistoryItemOptional = TransferHistoryRepository.findById(request.getId());

        // TODO: Throw Exception if ID doesn't exist in db

        TransferHistoryItem TransferHistoryItem = TransferHistoryItemOptional.get();
        TransferHistoryItem.setPlayerName(request.getName());
        TransferHistoryItem.setType(request.getType());
        TransferHistoryItem.setAmount(request.getAmount());
        TransferHistoryItem.setDuration(request.getDuration());
        TransferHistoryItem.setDate(LocalDateTime.now());

        TransferHistoryRepository.save(TransferHistoryItem);

        TransferHistoryResponse response = TransferHistoryMapper.apply(TransferHistoryItemOptional.get());
        return response;
    }

    @Override
    public void deleteTransferHistoryItem(UUID id) {
        Optional<TransferHistoryItem> TransferHistoryItemOptional = TransferHistoryRepository.findById(id);

        // TODO: Throw Exception if ID doesn't exist in db

        TransferHistoryRepository.delete(TransferHistoryItemOptional.get());
    }
}
