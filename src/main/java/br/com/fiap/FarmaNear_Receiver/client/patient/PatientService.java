package br.com.fiap.FarmaNear_Receiver.client.patient;

import br.com.fiap.FarmaNear_Receiver.client.patient.fallback.PatientServiceFallback;
import br.com.fiap.FarmaNear_Receiver.client.patient.response.MedicationDTO;
import br.com.fiap.FarmaNear_Receiver.client.patient.response.PatientAddressDTO;
import br.com.fiap.FarmaNear_Receiver.client.patient.response.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PatientService",
        url = "${patient.service.url}",
        fallback = PatientServiceFallback.class)
public interface PatientService {

    @PostMapping(value="/patient/create")
    ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDto);

    @GetMapping(value="/patient/read/{patientId}")
    ResponseEntity<PatientDTO> readPatient(@PathVariable Long patientId);

    @PutMapping(value="/patient/update")
    ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patientDto);

    @DeleteMapping(value="/patient/delete/{patientId}")
    ResponseEntity<String> deletePatient(@PathVariable Long patientId);


    @PostMapping(value="/medication/create")
    ResponseEntity<MedicationDTO> createMedication(@RequestBody MedicationDTO medicationDto);

    @GetMapping(value = "/medication/read/{medicationId}")
    ResponseEntity<MedicationDTO> readMedication(@PathVariable Long medicationId);

    @GetMapping(value = "/medication/patient/read/{patientId}")
    ResponseEntity<List<MedicationDTO>> readMedicationPatient(@PathVariable Long patientId);

    @PutMapping(value = "/medication/update")
    ResponseEntity<MedicationDTO> updateMedication(@RequestBody MedicationDTO medicationDto);

    @DeleteMapping(value = "/medication/delete/{medicationId}")
    ResponseEntity<String> deleteMedication(@PathVariable Long medicationId);


    @PostMapping(value = "/address/create")
    ResponseEntity<PatientAddressDTO> createAddress(@RequestBody PatientAddressDTO addressDto);

    @GetMapping(value = "/address/read/{addressId}")
    ResponseEntity<PatientAddressDTO> readAddress(@PathVariable Long addressId);

    @GetMapping(value = "/address/patient/read/{patientId}")
    ResponseEntity<PatientAddressDTO> readAddressPatient(@PathVariable Long patientId);

    @PutMapping(value = "/address/update")
    ResponseEntity<PatientAddressDTO> updateAddress(@RequestBody PatientAddressDTO addressDto);

    @DeleteMapping(value = "/address/delete/{addressId}")
    ResponseEntity<String> deleteAddress(@PathVariable Long addressId);

}
