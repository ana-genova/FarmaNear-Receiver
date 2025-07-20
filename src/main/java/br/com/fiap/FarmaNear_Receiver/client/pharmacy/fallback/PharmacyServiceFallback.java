package br.com.fiap.FarmaNear_Receiver.client.pharmacy.fallback;

import br.com.fiap.FarmaNear_Receiver.client.pharmacy.PharmacyService;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.request.CreateDrugstoreDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.DrugstoreDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.GetDrugstoreByProductDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.GetProductDataDTO;
import br.com.fiap.FarmaNear_Receiver.client.pharmacy.response.PharmacyProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class PharmacyServiceFallback implements PharmacyService {

    @Override
    public DrugstoreDTO createDrugstore(CreateDrugstoreDTO createDrugstoreDTO, String token) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de farmácias");
    }

    @Override
    public List<PharmacyProductDTO> uploadCsv(MultipartFile file, String drugstoreCnpj, String token) throws Exception {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de farmácias");
    }

    @Override
    public ResponseEntity<PharmacyProductDTO> importNewProduct(PharmacyProductDTO productDto, String token) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de farmácias");
    }

    @Override
    public ResponseEntity<GetDrugstoreByProductDTO> getDrugstoreByProduct(String productName, String token) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de farmácias");
    }

    @Override
    public ResponseEntity<List<GetProductDataDTO>> getProducts(String productName, String token) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de farmácias");
    }

    @Override
    public ResponseEntity<List<GetProductDataDTO>> getProductsByCnpj(String cnpj, String token) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de farmácias");
    }

    @Override
    public ResponseEntity<List<GetProductDataDTO>> getDrugstore(String cnpj, String token) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de farmácias");
    }

}
