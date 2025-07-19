package br.com.fiap.FarmaNear_Receiver.client.finder.fallback;

import br.com.fiap.FarmaNear_Receiver.client.finder.FinderService;
import br.com.fiap.FarmaNear_Receiver.client.finder.request.FinderAddressReceiver;
import br.com.fiap.FarmaNear_Receiver.client.finder.request.FinderCoordinatesReceiver;
import br.com.fiap.FarmaNear_Receiver.client.finder.response.FinderResponse;

import java.util.List;

public class FinderServiceFallback implements FinderService {

    @Override
    public List<FinderResponse> findPharmaciesByProductAndAddress(FinderAddressReceiver finderReceiver) {
        throw new RuntimeException("Service is currently unavailable. Please try again later.");
    }

    @Override
    public List<FinderResponse> findPharmaciesByProductAndAddress(FinderCoordinatesReceiver finderReceiver) {
        throw new RuntimeException("Service is currently unavailable. Please try again later.");
    }

}
