package com.example.hexagonal.infrastructure.repository;

import com.example.hexagonal.infrastructure.entity.ListingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingJpaRepository extends JpaRepository<ListingEntity, Long> {

}
