package com.system.farecard.jpa;

import com.system.farecard.entity.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {
    CardDetails findByCardNumber(String cardNumber);

    @Transactional
    @Modifying
    @Query("update CardDetails c set c.balance = latestBalance where c.cardNumber = cardNumber")
    void updateCardBalance(@Param("cardNumber") String cardNumber, @Param("balance") double latestBalance);
}
