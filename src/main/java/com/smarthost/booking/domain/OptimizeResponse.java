package com.smarthost.booking.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OptimizeResponse {
    Integer usageEconomy;
    Integer amountPaidEconomy;
    Integer usagePremium;
    Integer amountPaidPremium;
}
