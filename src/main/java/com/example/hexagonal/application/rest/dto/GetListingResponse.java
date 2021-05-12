package com.example.hexagonal.application.rest.dto;

import com.example.hexagonal.domain.ListingStatus;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
@Builder
public class GetListingResponse {

    @NotNull String name;

    @NotNull String description;

    @NotNull BigDecimal price;

    @NotNull ListingStatus listingStatus;

}
