package com.example.hexagonal.infrastructure.adapter;

import com.example.hexagonal.domain.Listing;
import com.example.hexagonal.infrastructure.entity.ListingEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ListingPersistenceConverter {


    public static Listing toListing(final ListingEntity listingEntity) {
        return Listing.builder()
                      .id(listingEntity.getId())
                      .name(listingEntity.getName())
                      .description(listingEntity.getDescription())
                      .price(listingEntity.getPrice())
                      .status(listingEntity.getStatus())
                      .build();
    }

    public static ListingEntity toListingEntity(final Listing listing) {
        return ListingEntity.builder()
                            .id(listing.getId())
                            .name(listing.getName())
                            .description(listing.getDescription())
                            .price(listing.getPrice())
                            .status(listing.getStatus())
                            .build();
    }

}
