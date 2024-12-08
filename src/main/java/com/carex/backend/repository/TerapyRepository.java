package com.carex.backend.repository;

import com.carex.backend.entity.Terapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TerapyRepository extends JpaRepository<Terapy, Long> {
    @Query("SELECT t from Terapy t ORDER BY t.isAlternative DESC")
    List<Terapy> findAllTerapySortingIsAlternativeFirst();
}
