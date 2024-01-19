package com.assestment.transaction.repository;

import com.assestment.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "SELECT * FROM transactions WHERE fruit_id = :fruitId", nativeQuery = true)
    List<Transaction> findTransactionsByFruitId(@Param("fruitId") Long fruitId);

    // additional queries if needed
}