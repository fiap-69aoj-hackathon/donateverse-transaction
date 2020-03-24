package com.donateverse.transaction.controller;

import com.donateverse.transaction.converter.TransactionConverter;
import com.donateverse.transaction.dto.TransactionRequest;
import com.donateverse.transaction.dto.TransactionResponse;
import com.donateverse.transaction.entity.TransactionEntity;
import com.donateverse.transaction.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
@Api(value = "Transações", tags = {"API de transações"})
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionConverter transactionConverter;

    @ApiOperation(value = "Insere uma nova transação")
    @PostMapping
    public ResponseEntity<TransactionResponse> save(@Valid @RequestBody final TransactionRequest request) {
        TransactionEntity transactionEntity = transactionConverter.toTransactionEntity(request);
        TransactionEntity transactionEntityResponse = transactionService.save(transactionEntity);

        TransactionResponse transactionResponse = transactionConverter
            .toTransactionResponse(transactionEntityResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponse);
    }

    @ApiOperation(value = "Busca uma lista com todas transações")
    @GetMapping
    public List<TransactionResponse> list() {
        List<TransactionEntity> listTransactions = transactionService.list();
        return listTransactions.stream()
            .map(transaction -> transactionConverter.toTransactionResponse(transaction))
            .collect(Collectors.toList());
    }

    @ApiOperation(value = "Busca as transações de um usuário")
    @GetMapping("/user/{id}")
    public List<TransactionResponse> findByUserId(@PathVariable final Long id) {
        List<TransactionEntity> listTransactions = transactionService.findByUserId(id);
        return listTransactions.stream()
            .map(transaction -> transactionConverter.toTransactionResponse(transaction))
            .collect(Collectors.toList());
    }

    @ApiOperation(value = "Atualiza o status de uma transação")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
        @RequestBody TransactionRequest transactionRequest) {
        Optional<TransactionEntity> transactionEntityOptional = transactionService.findById(id);

        if (transactionEntityOptional.isPresent()) {
            TransactionEntity transactionEntity = transactionEntityOptional.get();
            transactionEntity.setStatus(transactionRequest.getStatus());
            transactionEntity = transactionService.save(transactionEntity);

            return ResponseEntity.ok(transactionEntity);
        }

        return ResponseEntity.badRequest().build();
    }

}
