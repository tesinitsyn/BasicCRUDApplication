package com.example.BasicCRUDApplication.repository;

import com.example.BasicCRUDApplication.model.Disk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiskRepository extends JpaRepository<Disk, Long> {
}
