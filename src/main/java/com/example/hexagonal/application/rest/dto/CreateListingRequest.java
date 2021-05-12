package com.example.hexagonal.application.rest.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
@Builder
public class CreateListingRequest {

    @NotNull String name;

    @NotNull String description;

    @NotNull BigDecimal price;

}
