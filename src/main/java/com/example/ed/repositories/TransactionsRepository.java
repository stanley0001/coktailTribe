package com.example.ed.repositories;

import com.example.ed.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions,Long> {
}
