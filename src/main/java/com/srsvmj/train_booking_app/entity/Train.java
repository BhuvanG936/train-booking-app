package com.srsvmj.train_booking_app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="tbl_train")
@ToString
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="passenger_name")
    private String passengerName;

    @Column(name="passenger_age")
    private int passengerAge;

    @Column(name="passenger_gender")
    private String passengerGender;

    @Column(name="birth_preference")
    private String birthPreference;

    private String nationality;

    private String address;

    private String state;

    private String city;

    private String mobile;

    private String email;

    private int pincode;

}

