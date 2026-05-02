package com.klef.fsad.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transport")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "transport_date")
    public String date;

    @Column(name = "status")
    public String status;

    @Column(name = "vehicle_type")
    public String vehicleType;

    @Column(name = "fare")
    public double fare;

    public Transport() {
    }
    public Transport(String name, String date, String status, String vehicleType, double fare) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.vehicleType = vehicleType;
        this.fare = fare;
    }
}
