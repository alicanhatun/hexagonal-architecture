package com.example.hexagonal.application.rest;

import com.example.hexagonal.application.rest.dto.CreateListingRequest;
import com.example.hexagonal.application.rest.dto.GetListingResponse;
import com.example.hexagonal.domain.port.ListingServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/listing")
public class ListingController {

    private final ListingServicePort listingServicePort;

    @GetMapping("/{listingId}")
    @ResponseStatus(OK)
    public GetListingResponse getListing(@PathVariable final Long listingId) {
        return ListingApiConverter.toGetListingResponse(listingServicePort.findListing(listingId));
    }

    @PutMapping("/publish/{listingId}")
    @ResponseStatus(OK)
    public void publishListing(@PathVariable final Long listingId) {
        listingServicePort.publish(listingId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Long createListing(@RequestBody CreateListingRequest createListingRequest) {
        return listingServicePort.createListing(ListingApiConverter.toListing(createListingRequest));
    }

}
