package br.com.fiap.FarmaNear_Receiver.controller;

import br.com.fiap.FarmaNear_Receiver.client.patient.PatientService;
import br.com.fiap.FarmaNear_Receiver.client.patient.response.MedicationDTO;
import br.com.fiap.FarmaNear_Receiver.client.patient.response.PatientAddressDTO;
import br.com.fiap.FarmaNear_Receiver.client.patient.response.PatientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController implements PatientService {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @PostMapping(value="/patient/create")
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDto) {
        return patientService.createPatient(patientDto);
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping(value="/patient/read/{patientId}")
    public ResponseEntity<PatientDTO> readPatient(@PathVariable Long patientId) {
        return patientService.readPatient(patientId);
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @PutMapping(value="/patient/update")
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patientDto) {
        return patientService.updatePatient(patientDto);
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @DeleteMapping(value="/patient/delete/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
        return patientService.deletePatient(patientId);
    }


    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @PostMapping(value="/medication/create")
    public ResponseEntity<MedicationDTO> createMedication(@RequestBody MedicationDTO medicationDto) {
        return patientService.createMedication(medicationDto);
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping(value = "/medication/read/{medicationId}")
    public ResponseEntity<MedicationDTO> readMedication(@PathVariable Long medicationId) {
        return patientService.readMedication(medicationId);
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping(value = "/medication/patient/read/{patientId}")
    public ResponseEntity<List<MedicationDTO>> readMedicationPatient(@PathVariable Long patientId) {
        return patientService.readMedicationPatient(patientId);
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @PutMapping(value = "/medication/update")
    public ResponseEntity<MedicationDTO> updateMedication(@RequestBody MedicationDTO medicationDto) {
        return patientService.updateMedication(medicationDto);
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @DeleteMapping(value = "/medication/delete/{medicationId}")
    public ResponseEntity<String> deleteMedication(@PathVariable Long medicationId) {
        return patientService.deleteMedication(medicationId);
    }


    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @PostMapping(value = "/address/create")
    public ResponseEntity<PatientAddressDTO> createAddress(@RequestBody PatientAddressDTO addressDto) {
        return patientService.createAddress(addressDto);
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping(value = "/address/read/{addressId}")
    public ResponseEntity<PatientAddressDTO> readAddress(@PathVariable Long addressId) {
        return patientService.readAddress(addressId);
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping(value = "/address/patient/read/{patientId}")
    public ResponseEntity<PatientAddressDTO> readAddressPatient(@PathVariable Long patientId) {
        return patientService.readAddressPatient(patientId);
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @PutMapping(value = "/address/update")
    public ResponseEntity<PatientAddressDTO> updateAddress(@RequestBody PatientAddressDTO addressDto) {
        return patientService.updateAddress(addressDto);
    }

    @Override
    @PreAuthorize("hasRole('PATIENT')")
    @DeleteMapping(value = "/address/delete/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId) {
        return patientService.deleteAddress(addressId);
    }

}
