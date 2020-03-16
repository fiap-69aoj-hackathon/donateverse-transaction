package com.donateverse.transaction.repository;

import com.donateverse.transaction.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    TransactionEntity findByIdUser(final Long id);

}
