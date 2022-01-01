package com.system.farecard.jpa;

import com.system.farecard.entity.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {
    CardDetails findByCardNumber(String cardNumber);
}
