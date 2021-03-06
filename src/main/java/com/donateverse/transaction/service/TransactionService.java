package com.donateverse.transaction.service;

import com.donateverse.transaction.entity.TransactionEntity;
import com.donateverse.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionEntity save(final TransactionEntity transactionEntity) {
        transactionEntity.setCreationDate(new Date());
        return transactionRepository.save(transactionEntity);
    }

    public List<TransactionEntity> list() {
        return transactionRepository.findAll();
    }

    public Optional<TransactionEntity> findById(final Long id) {
        return transactionRepository.findById(id);
    }

    public List<TransactionEntity> findByUserId(final Long id) {
        return transactionRepository.findByIdUser(id);
    }

}
