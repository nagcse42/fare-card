package com.system.farecard.jpa;

import com.system.farecard.entity.TouchPointDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouchPointRepository extends JpaRepository<TouchPointDetails, Long> {
    List<TouchPointDetails> findByCardNumber(String cardNumber);
}