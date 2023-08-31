package com.picpaysimplificado.picpaysimplificado.domain.repositories;

import com.picpaysimplificado.picpaysimplificado.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepositories extends JpaRepository<Transaction, Long> {
}
