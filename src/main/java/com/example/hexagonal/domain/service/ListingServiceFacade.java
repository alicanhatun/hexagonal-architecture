package com.example.hexagonal.domain.service;

import com.example.hexagonal.domain.Listing;
import com.example.hexagonal.domain.port.ListingPersistencePort;
import com.example.hexagonal.domain.port.ListingServicePort;
import com.example.hexagonal.exception.ListingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListingServiceFacade implements ListingServicePort {

    private final ListingPersistencePort listingPersistencePort;

    @Override
    public Long createListing(final Listing listing) {
        listing.createListing();
        listingPersistencePort.save(listing);
        return listing.getId();
    }

    @Override
    public void publish(final Long id) {
        final var listing = findListing(id);
        listing.publish();
        listingPersistencePort.save(listing);
    }

    @Override
    public Listing findListing(Long id) {
        return listingPersistencePort.findById(id).orElseThrow(() -> new ListingException("Listing doesn't exist"));
    }

}
