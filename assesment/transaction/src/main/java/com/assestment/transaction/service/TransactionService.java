package com.assestment.transaction.service;

import com.assestment.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    // methods for CRUD operations on transactions, Java Stream operations, Native SQL queries
}