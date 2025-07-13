package br.com.fiap.FarmaNear_Receiver.client.pharmacy.response;

import java.util.List;

public record GetDrugstoreByProductDTO(String productName, List<DrugstoreDTO> drugstores) {
}
