package com.smarthost.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CategoryEnum {
    PREMIUM("Premium"),
    ECONOMY("Economy");

    @Getter
    private String description;

}