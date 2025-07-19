package br.com.fiap.FarmaNear_Receiver.controller;

import br.com.fiap.FarmaNear_Receiver.client.finder.FinderService;
import br.com.fiap.FarmaNear_Receiver.client.finder.request.FinderAddressReceiver;
import br.com.fiap.FarmaNear_Receiver.client.finder.request.FinderCoordinatesReceiver;
import br.com.fiap.FarmaNear_Receiver.client.finder.response.FinderResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinderController {

    private final FinderService finderService;

    public FinderController(FinderService finderService) {
        this.finderService = finderService;
    }

    @PostMapping("/local/medicine/address")
    public List<FinderResponse> findPharmaciesByProductAndAddress(@RequestBody FinderAddressReceiver finderReceiver) {
        return finderService.findPharmaciesByProductAndAddress(finderReceiver);
    }

    @PostMapping("/local/medicine/coordinates")
    public List<FinderResponse> findPharmaciesByProductAndAddress(@RequestBody FinderCoordinatesReceiver finderReceiver) {
        return finderService.findPharmaciesByProductAndAddress(finderReceiver);
    }

}
