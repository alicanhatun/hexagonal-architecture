package com.example.hexagonal.domain.port;

import com.example.hexagonal.domain.Listing;

import java.util.Optional;

public interface ListingPersistencePort {

    Optional<Listing> findById(Long id);

    void save(Listing listing);
}
