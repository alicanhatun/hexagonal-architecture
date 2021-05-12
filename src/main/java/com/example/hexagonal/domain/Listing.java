package com.example.hexagonal.domain;

import com.example.hexagonal.exception.ListingException;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import static com.example.hexagonal.domain.ListingStatus.CREATED;
import static com.example.hexagonal.domain.ListingStatus.PUBLISHED;

@Data
@Builder
public class Listing {

    private Long id;

    private String name;

    private String description;

    private ListingStatus status;

    private BigDecimal price;

    public void publish() {
        validateState();
        this.status = PUBLISHED;
    }

    private void validateState() {
        if (PUBLISHED.equals(status) || price == null) {
            throw new ListingException("The listing status is not eligible.");
        }
    }

    public void createListing() {
        this.status = CREATED;
    }

}
