package com.smarthost.booking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
    private CategoryEnum category;
    private Integer pricePaid;
}
