package br.com.fiap.FarmaNear_Receiver.client.patient.response;

import java.time.LocalDate;

public record MedicationDTO(Long id, String name, String dosage, String administrationRoute, String frequency,
                            LocalDate startDate, LocalDate endDate, String notes, Long idPatient) {
}
