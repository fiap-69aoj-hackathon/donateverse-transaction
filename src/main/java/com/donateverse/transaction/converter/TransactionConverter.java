package com.donateverse.transaction.converter;

import com.donateverse.transaction.dto.TransactionRequest;
import com.donateverse.transaction.dto.TransactionResponse;
import com.donateverse.transaction.entity.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter {

    public TransactionEntity toTransactionEntity(final TransactionRequest request) {
        return TransactionEntity.builder()
            .idUser(request.getIdUser())
            .idProduto(request.getIdProduto())
            .build();
    }

    public TransactionResponse toTransactionResponse(final TransactionEntity entity) {
        return TransactionResponse.builder()
            .id(entity.getId())
            .idUser(entity.getIdUser())
            .idProduto(entity.getIdProduto())
            .status(entity.getStatus())
            .creationDate(entity.getCreationDate())
            .build();
    }

}
