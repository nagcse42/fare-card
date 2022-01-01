package com.system.farecard.jpa;

import com.system.farecard.entity.StationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationDetailsRepository  extends JpaRepository<StationDetails, Long> {
    List<StationDetails> findByName(String name);
}
