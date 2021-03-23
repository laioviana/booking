package com.smarthost.booking.service;

import com.smarthost.booking.domain.OptimizeRequest;
import com.smarthost.booking.domain.OptimizeResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomService {

    public OptimizeResponse optimizeRooms(OptimizeRequest optimizeRequest) {
        List<Integer> economyRoomOffers = new ArrayList<>();
        List<Integer> premiumRoomOffers = new ArrayList<>();
        List<Integer> potentialGuestOrdered = optimizeRequest.getPotentialGuests().stream().sorted().collect(Collectors.toList());

        //Fetching offers to higher clients
        potentialGuestOrdered.stream().filter(offer -> offer  >= 100).collect(Collectors.toList()).forEach(offer -> {
            if(premiumRoomOffers.size() < optimizeRequest.getRoomAvailablePremium()){
                premiumRoomOffers.add(offer);
                potentialGuestOrdered.remove(offer);
            }
        });

        //Fetching offers to lower clients
        potentialGuestOrdered.stream().filter(offer -> offer  < 100).collect(Collectors.toList()).forEach(offer ->
        {
            if(premiumRoomOffers.size() < optimizeRequest.getRoomAvailablePremium()) {
                premiumRoomOffers.add(offer);
                potentialGuestOrdered.remove(offer);
            } else if(economyRoomOffers.size() < optimizeRequest.getRoomAvailableEconomy()){
                economyRoomOffers.add(offer);
                potentialGuestOrdered.remove(offer);
            }
        });

        return OptimizeResponse.builder()
                .usageEconomy(economyRoomOffers.size())
                .usagePremium(premiumRoomOffers.size())
                .amountPaidEconomy(economyRoomOffers.stream().mapToInt(Integer::intValue).sum())
                .amountPaidPremium(premiumRoomOffers.stream().mapToInt(Integer::intValue).sum()).build();

    }

}
