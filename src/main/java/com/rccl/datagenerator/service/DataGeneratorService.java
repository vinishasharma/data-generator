package com.rccl.datagenerator.service;

import com.rccl.datagenerator.model.CrewAssignment;
import com.rccl.datagenerator.model.CrewPersonal;
import com.rccl.datagenerator.repository.CrewAssignmentRepository;
import com.rccl.datagenerator.repository.CrewPersonalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DataGeneratorService {

    private CrewPersonalRepository crewPersonalRepository;
    private CrewAssignmentRepository crewAssignmentRepository;

    public Mono<String> GenerateCrewProfileData(int startId, int endId) {

        List<CrewPersonal> crewPersonalDataList = new ArrayList<>();

        for(int i = startId; i<=endId; i++) {

            crewPersonalDataList.add(CrewPersonal.builder().crewMemberId(Integer.toString(i)).build());
        }

        Flux<CrewPersonal> crewPersonalFlux = crewPersonalRepository.saveAll(crewPersonalDataList);

        crewPersonalFlux.subscribe(a -> System.out.println("crew profile data inserted"),
                err -> System.out.println("errror...."+err),
                () -> System.out.println("jon completed.............."));

        return Mono.just("Data generation started for crew profile..........");
    }

    public Mono<String> GenerateCrewAssignmentData(int startId, int endId, String shipCode, String date) {

        List<CrewAssignment> crewAssignmentList = new ArrayList<>();

        for(int i = startId; i<=endId; i++) {

            crewAssignmentList.add(CrewAssignment.builder().crewMemberId(Integer.toString(i)).shipCode(shipCode).signonDate(date).build());
        }

        Flux<CrewAssignment> crewAssignmentFlux = crewAssignmentRepository.saveAll(crewAssignmentList);

        crewAssignmentFlux.subscribe(a -> System.out.println("crew assignment data inserted"),
                err -> System.out.println("errror...."+err),
                () -> System.out.println("jon completed.............."));
//
        return Mono.just("Data generation started for Crew Assignment..........");
    }

}
