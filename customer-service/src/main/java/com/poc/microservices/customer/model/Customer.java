package com.poc.microservices.customer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Rustam_Kadyrov on 26.04.2017.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "customer_table")
public class Customer {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "payload")
    private String payload;

    @Builder
    public Customer(String id, String name, String payload) {
        this.id = id;
        this.name = name;
        this.payload = payload;
    }
}
