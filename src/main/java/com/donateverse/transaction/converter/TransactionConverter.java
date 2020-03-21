package com.donateverse.transaction.converter;

import com.donateverse.transaction.dto.ProductResponse;
import com.donateverse.transaction.dto.TransactionRequest;
import com.donateverse.transaction.dto.TransactionResponse;
import com.donateverse.transaction.entity.ProductEntity;
import com.donateverse.transaction.entity.TransactionEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TransactionConverter {

    public TransactionEntity toTransactionEntity(final TransactionRequest request) {
        return TransactionEntity.builder()
            .idUser(request.getIdUser())
            .products(
                request.getProducts().stream().map(r ->
                    ProductEntity.builder()
                        .description(r.getDescription())
                        .amount(r.getAmount())
                        .build()
                    ).collect(Collectors.toList())
                )
            .status(request.getStatus())
            .build();
    }

    public TransactionResponse toTransactionResponse(final TransactionEntity entity) {
        return TransactionResponse.builder()
            .id(entity.getId())
            .idUser(entity.getIdUser())
            .products(
                entity.getProducts().stream().map(e ->
                    ProductResponse.builder()
                    .id(e.getId())
                    .description(e.getDescription())
                    .amount(e.getAmount())
                    .build()
                ).collect(Collectors.toList())
            )
            .status(entity.getStatus())
            .creationDate(entity.getCreationDate())
            .build();
    }

}
