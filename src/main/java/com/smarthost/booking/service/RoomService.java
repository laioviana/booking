package com.smarthost.booking.service;

import com.smarthost.booking.domain.OptimizeRequest;
import com.smarthost.booking.domain.OptimizeResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class RoomService {

    public OptimizeResponse optimizeRooms(OptimizeRequest optimizeRequest) {
        List<Integer> economyRoomOffers = new ArrayList<>();
        List<Integer> premiumRoomOffers = new ArrayList<>();
        List<Integer> potentialGuestOrdered = optimizeRequest.getPotentialGuests().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> higherOffers = potentialGuestOrdered.stream().filter(offer -> offer  >= 100).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> lowerOffers = potentialGuestOrdered.stream().filter(offer -> offer  < 100).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //optimizing higher clients to premium rooms
        higherOffers.forEach(offer -> {
            if(premiumRoomOffers.size() < optimizeRequest.getRoomAvailablePremium()){
                premiumRoomOffers.add(offer);
                potentialGuestOrdered.remove(offer);
            }
        });
        AtomicInteger economyLeftOver = new AtomicInteger(lowerOffers.size() - optimizeRequest.getRoomAvailableEconomy());
        //optimizing lower  clients to premium/economy rooms
        lowerOffers.forEach(offer ->
        {
            if(economyLeftOver.get() > 0 && premiumRoomOffers.size() < optimizeRequest.getRoomAvailablePremium()) {
                premiumRoomOffers.add(offer);
                potentialGuestOrdered.remove(offer);
                economyLeftOver.decrementAndGet();
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
