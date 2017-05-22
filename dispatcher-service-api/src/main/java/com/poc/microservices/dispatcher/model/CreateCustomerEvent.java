package com.poc.microservices.dispatcher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Rustam_Kadyrov on 19.05.2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("CreateCustomerEvent")
public class CreateCustomerEvent extends Event {
    private String name;
}
