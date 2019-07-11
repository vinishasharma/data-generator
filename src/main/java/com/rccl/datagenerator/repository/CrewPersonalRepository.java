package com.rccl.datagenerator.repository;

import com.rccl.datagenerator.model.CrewPersonal;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CrewPersonalRepository extends ReactiveCouchbaseRepository<CrewPersonal, String> {

    Flux<CrewPersonal> saveAll(List<CrewPersonal> crewChatProfiles);
}
