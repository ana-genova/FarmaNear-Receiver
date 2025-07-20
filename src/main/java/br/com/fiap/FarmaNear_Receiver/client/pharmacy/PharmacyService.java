package br.com.fiap.FarmaNear_Receiver.client.pharmacy;

import br.com.fiap.FarmaNear_Receiver.client.pharmacy.fallback.PharmacyServiceFallback;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.request.CreateDrugstoreDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.DrugstoreDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.GetDrugstoreByProductDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.GetProductDataDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.PharmacyProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "PharmacyService",
        url = "${pharmacy.service.url}",
        fallback = PharmacyServiceFallback.class)
public interface PharmacyService {

    @PostMapping("/drugstore/register")
    DrugstoreDTO createDrugstore(@RequestBody CreateDrugstoreDTO createDrugstoreDTO, @RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @PostMapping(value = "/product/upload-csv/{drugstoreCnpj}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    List<PharmacyProductDTO> uploadCsv(@RequestPart("file") MultipartFile file, @PathVariable String drugstoreCnpj, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) throws Exception;

    @PostMapping("/product")
    ResponseEntity<PharmacyProductDTO> importNewProduct(@RequestBody PharmacyProductDTO productDto, @RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @GetMapping("/product")
    ResponseEntity<GetDrugstoreByProductDTO> getDrugstoreByProduct(@RequestParam String productName, @RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @GetMapping("/product/getProducts")
    ResponseEntity<List<GetProductDataDTO>> getProducts(@RequestBody String productName, @RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @GetMapping("/product/getProductsByCnpj")
    ResponseEntity<List<GetProductDataDTO>> getProductsByCnpj(@RequestParam String cnpj, @RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @GetMapping("/drugstore")
    ResponseEntity<List<GetProductDataDTO>> getDrugstore(@RequestParam String cnpj, @RequestHeader(HttpHeaders.AUTHORIZATION) String token);

}
