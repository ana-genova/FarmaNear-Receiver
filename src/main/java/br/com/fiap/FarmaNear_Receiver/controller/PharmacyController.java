package br.com.fiap.FarmaNear_Receiver.controller;

import br.com.fiap.FarmaNear_Receiver.client.pharmacy.PharmacyService;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.request.CreateDrugstoreDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.DrugstoreDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.GetDrugstoreByProductDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.GetProductDataDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.PharmacyProductDTO;
import br.com.fiap.FarmaNear_Receiver.infra.security.TokenHolder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {

    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @PreAuthorize("hasRole('PHARMACY')")
    @PostMapping("/finishUserCreation")
    public ResponseEntity<?> finishUserCreation(@RequestBody CreateDrugstoreDTO userInfoDTO) {
        pharmacyService.createDrugstore(userInfoDTO, TokenHolder.getToken());

        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('PHARMACY')")
    @PostMapping("/register/drugstore")
    public DrugstoreDTO createDrugstore(CreateDrugstoreDTO createDrugstoreDTO) {
        return pharmacyService.createDrugstore(createDrugstoreDTO, TokenHolder.getToken());
    }

    @PreAuthorize("hasRole('PHARMACY')")
    @PostMapping(value = "/product/upload-csv/{drugstoreCnpj}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<PharmacyProductDTO> uploadCsv(@RequestParam("file") MultipartFile file, @PathVariable String drugstoreCnpj)
            throws Exception {
        return pharmacyService.uploadCsv(file, drugstoreCnpj, TokenHolder.getToken());
    }

    @PreAuthorize("hasRole('PHARMACY')")
    @PostMapping("/product")
    public ResponseEntity<PharmacyProductDTO> importNewProduct(@RequestBody PharmacyProductDTO productDto) {
        return pharmacyService.importNewProduct(productDto, TokenHolder.getToken());
    }

    @PreAuthorize("hasRole('PHARMACY')")
    @GetMapping("/product")
    public ResponseEntity<GetDrugstoreByProductDTO> getDrugstoreByProduct(@RequestParam String productName) {
        return pharmacyService.getDrugstoreByProduct(productName, TokenHolder.getToken());
    }

    @PreAuthorize("hasRole('PHARMACY')")
    @GetMapping("/product/getProducts")
    public ResponseEntity<List<GetProductDataDTO>> getProducts(@RequestBody String productName) {
        return pharmacyService.getProducts(productName, TokenHolder.getToken());
    }
}
