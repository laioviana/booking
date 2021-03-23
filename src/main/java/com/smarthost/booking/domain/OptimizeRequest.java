package com.smarthost.booking.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OptimizeRequest {
    Integer roomAvailableEconomy;
    Integer roomAvailablePremium;
    List<Integer> potentialGuests;
}
