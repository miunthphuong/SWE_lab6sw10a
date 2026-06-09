package edu.miu.cs.lab10a;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.cs.lab10a.model.Patient;
import edu.miu.cs.lab10a.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Lab10aApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab10aApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientService patientService) {
        return args -> {
            List<Patient> patients = patientService.getAllPatientsSortedByAgeDescending();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            String patientsJson = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(patients);

            System.out.println(patientsJson);
        };
    }
}