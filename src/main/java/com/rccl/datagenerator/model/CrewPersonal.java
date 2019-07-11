package com.rccl.datagenerator.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.USE_ATTRIBUTES;

@Getter
@Setter
@Document
@Builder(toBuilder = true)
@AllArgsConstructor
public class CrewPersonal {

    @Id
    @GeneratedValue(delimiter = "::", strategy = USE_ATTRIBUTES)
    String id;

    @Field
    @IdAttribute(order = 0)
    String crewMemberId;

    @Field
    @Builder.Default
    String activeStatus = "TRUE";

    @Field
    @Builder.Default
    String brand = "R";

    @Field
    @Builder.Default
    String businessUnit = "0218472";

    @Field
    @Builder.Default
    String crewNationality = "USA";

    @Field
    @Builder.Default
    String docType = "CREW_BASIC";

    @Field
    @Builder.Default
    String emailAddress = "test@rccl.com";

    @Field
    @Builder.Default
    String firstName = "test";

    @Field
    @Builder.Default
    String lastName = "test";

    @Field
    @Builder.Default
    String lastUpdateSource = "JDE";

    @Field
    @Builder.Default
    String lastUpdated = "20180917T173001";

}



