package com.rccl.datagenerator.controller;

import com.rccl.datagenerator.service.DataGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class DataGeneratorController {

    private DataGeneratorService dataGeneratorService;

    @GetMapping(value = "/generate/crew/profile/data/{startId}/{endId}")
    public Mono<String> GenerateCrewProfileData(@PathVariable("startId") int startId, @PathVariable("endId") int endId) {
        return dataGeneratorService.GenerateCrewProfileData(startId, endId);
    }

    @GetMapping(value = "/generate/crew/assignment/data/{startId}/{endId}/{shipCode}/{sailDate}")
    public Mono<String> sGenerateCrewAssignmentData(@PathVariable("startId") int startId,
                                                    @PathVariable("endId") int endId,
                                                    @PathVariable("shipCode") String shipCode,
                                                    @PathVariable("sailDate") String sailDate) {

        return dataGeneratorService.GenerateCrewAssignmentData(startId, endId,shipCode,sailDate);
    }

}

