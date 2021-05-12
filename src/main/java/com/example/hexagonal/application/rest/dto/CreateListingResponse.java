package com.example.hexagonal.application.rest.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
public class CreateListingResponse {

    @NotNull Long id;

}
