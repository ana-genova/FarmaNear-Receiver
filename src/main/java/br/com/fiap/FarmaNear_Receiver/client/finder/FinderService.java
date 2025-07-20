package br.com.fiap.FarmaNear_Receiver.client.finder;

import br.com.fiap.FarmaNear_Receiver.client.finder.fallback.FinderServiceFallback;
import br.com.fiap.FarmaNear_Receiver.client.finder.request.FinderAddressReceiver;
import br.com.fiap.FarmaNear_Receiver.client.finder.request.FinderCoordinatesReceiver;
import br.com.fiap.FarmaNear_Receiver.client.finder.response.FinderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "FinderService",
        url = "${finder.service.url}",
        fallback = FinderServiceFallback.class)
public interface FinderService {

    @PostMapping("/local/medicine/address")
    List<FinderResponse> findPharmaciesByProductAndAddress(@RequestBody FinderAddressReceiver finderReceiver);

    @PostMapping("/local/medicine/coordinates")
    List<FinderResponse> findPharmaciesByProductAndAddress(@RequestBody FinderCoordinatesReceiver finderReceiver);

}
