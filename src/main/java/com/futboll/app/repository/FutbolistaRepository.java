package com.futboll.app.repository;

import com.futboll.app.entity.Futbolista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FutbolistaRepository extends JpaRepository<Futbolista,Long> {
}
