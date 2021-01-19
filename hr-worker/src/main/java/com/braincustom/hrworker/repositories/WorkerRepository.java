package com.braincustom.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braincustom.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
