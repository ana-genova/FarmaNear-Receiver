package br.com.fiap.FarmaNear_Receiver.client.patient.fallback;

import br.com.fiap.FarmaNear_Receiver.client.patient.PatientService;
import br.com.fiap.FarmaNear_Receiver.client.patient.response.MedicationDTO;
import br.com.fiap.FarmaNear_Receiver.client.patient.response.PatientAddressDTO;
import br.com.fiap.FarmaNear_Receiver.client.patient.response.PatientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientServiceFallback implements PatientService {

    @Override
    public ResponseEntity<PatientDTO> createPatient(PatientDTO patientDto) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<PatientDTO> readPatient(Long patientId) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<PatientDTO> updatePatient(PatientDTO patientDto) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<String> deletePatient(Long patientId) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<MedicationDTO> createMedication(MedicationDTO medicationDto) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<MedicationDTO> readMedication(Long medicationId) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<List<MedicationDTO>> readMedicationPatient(Long patientId) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<MedicationDTO> updateMedication(MedicationDTO medicationDto) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<String> deleteMedication(Long medicationId) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<PatientAddressDTO> createAddress(PatientAddressDTO addressDto) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<PatientAddressDTO> readAddress(Long addressId) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<PatientAddressDTO> readPatientByCpf(String patientCpf) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<PatientAddressDTO> readAddressPatient(Long patientId) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<PatientAddressDTO> updateAddress(PatientAddressDTO addressDto) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

    @Override
    public ResponseEntity<String> deleteAddress(Long addressId) {
        throw new RuntimeException("Erro ao realizar a comunicação com o serviço de pacientes");
    }

}
