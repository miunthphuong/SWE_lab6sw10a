package edu.miu.cs.lab10a.service;

import edu.miu.cs.lab10a.model.Patient;
import edu.miu.cs.lab10a.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatientsSortedByAgeDescending() {
        return patientRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Patient::getAge).reversed())
                .toList();
    }
}