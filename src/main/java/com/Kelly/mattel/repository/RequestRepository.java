package com.Kelly.mattel.repository;

import com.Kelly.mattel.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query(value = "select * from request where created_at >= (now() - Interval 30 Day) and status != 'PENDING' ", nativeQuery = true)
    List<Request> findAllWithDateBefore();

    @Query(value = "SELECT * From Request where status = 'PENDING' ", nativeQuery = true)
    List<Request> findAllByPending();

}
