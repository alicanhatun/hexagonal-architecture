package com.example.hexagonal.domain.port;

import com.example.hexagonal.domain.Listing;

public interface ListingServicePort {

    Long createListing(Listing listing);

    void publish(Long id);

    Listing findListing(Long listingId);
}
