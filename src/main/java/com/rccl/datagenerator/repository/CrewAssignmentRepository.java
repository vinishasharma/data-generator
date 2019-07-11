package com.rccl.datagenerator.repository;

import com.rccl.datagenerator.model.CrewAssignment;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CrewAssignmentRepository extends ReactiveCouchbaseRepository<CrewAssignment, String> {

    Flux<CrewAssignment> saveAll(List<CrewAssignment> crewChatProfiles);
}
