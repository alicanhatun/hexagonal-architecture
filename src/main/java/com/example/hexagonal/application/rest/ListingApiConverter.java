package com.example.hexagonal.application.rest;

import com.example.hexagonal.application.rest.dto.CreateListingRequest;
import com.example.hexagonal.application.rest.dto.GetListingResponse;
import com.example.hexagonal.domain.Listing;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ListingApiConverter {


    public static Listing toListing(final CreateListingRequest createListingRequest) {
        return Listing.builder()
                .name(createListingRequest.getName())
                .description(createListingRequest.getDescription())
                .price(createListingRequest.getPrice())
                .build();
    }


    public static GetListingResponse toGetListingResponse(final Listing listing) {
        return GetListingResponse.builder()
                      .name(listing.getName())
                      .description(listing.getDescription())
                      .price(listing.getPrice())
                      .listingStatus(listing.getStatus())
                      .build();
    }
}
