package com.siddd00474.repository;

import com.siddd00474.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowerRepository extends JpaRepository<Flower,Long> {
    List<Flower> findAllByNameAndStatus(String name,int status);
}
