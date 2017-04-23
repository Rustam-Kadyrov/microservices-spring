package org.test.microservices.dispatcher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.ZonedDateTime;

/**
 * Created by Rustam_Kadyrov on 19.05.2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("CreateOrderEvent")
public class CreateOrderEvent extends Event {
    private String customerName;
    private String number;
    private ZonedDateTime date;
}
