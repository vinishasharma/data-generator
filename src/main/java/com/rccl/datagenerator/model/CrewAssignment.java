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
public class CrewAssignment {

    @Id
    @GeneratedValue(delimiter = "::", strategy = USE_ATTRIBUTES)
    String id;

    @Field
    @IdAttribute(order = 0)
    String crewMemberId;

    @Field
    @IdAttribute(order = 1)
    String shipCode;

    @Field
    @IdAttribute(order = 3)
    @Builder.Default
    String docType = "SIGNON_SCHEDULE";

    @Field
    @Builder.Default
    String signoffDate = "20190126";

    @Field
    @Builder.Default
    String signoffPort = "SIN";

    @Field
    @IdAttribute(order = 2)
    String signonDate;

    @Field
    @Builder.Default
    String signonPort = "SIN";

    @Field
    @Builder.Default
    String activeStatus = "FALSE";

    @Field
    @Builder.Default
    String jdeSequenceNumber = null;

    @Field
    @Builder.Default
    String lastUpdateSource = "JDE";

    @Field
    @Builder.Default
    String lastUpdated = "20180917T190058";

    @Field
    @Builder.Default
    String positionJobCode = "SCON";

    @Field
    @Builder.Default
    String reasonCode = "ADJ";

    @Field
    @Builder.Default
    String signonPortTimezoneOffsetEST = "12";

    @Field
    @Builder.Default
    String soeaLink = null;

}
