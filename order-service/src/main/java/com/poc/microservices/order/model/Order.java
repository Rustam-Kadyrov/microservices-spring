package com.poc.microservices.order.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by Rustam_Kadyrov on 25.04.2017.
 */
@Getter
@Builder
@ToString
@Document(indexName = "order_index", type = "order_index")
public class Order {
    @Id
    private String id;

    @Field(type = FieldType.String)
    private String customerId;

    @Field(type = FieldType.String)
    private String number;

    @Field(type = FieldType.Long)
    private Long date;

}
