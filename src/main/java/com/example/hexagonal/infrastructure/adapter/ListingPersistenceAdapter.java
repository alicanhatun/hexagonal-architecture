package com.example.hexagonal.infrastructure.adapter;

import com.example.hexagonal.domain.Listing;
import com.example.hexagonal.domain.port.ListingPersistencePort;
import com.example.hexagonal.infrastructure.entity.ListingEntity;
import com.example.hexagonal.infrastructure.repository.ListingJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ListingPersistenceAdapter implements ListingPersistencePort {

    private final ListingJpaRepository listingJpaRepository;

    @Override
    public Optional<Listing> findById(Long id) {
        Optional<ListingEntity> listingEntityOptional = listingJpaRepository.findById(id);
        return listingEntityOptional.map(ListingPersistenceConverter::toListing);
    }

    @Override
    public void save(Listing listing) {
        var listingEntity = ListingPersistenceConverter.toListingEntity(listing);
        listingJpaRepository.save(listingEntity);
    }
}
