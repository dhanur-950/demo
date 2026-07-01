package com.ec2.demo.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Table(name = "empl0yee")
@Entity
@Data

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empid;

    @Column
    private String name;

    @Column
    private String dept;
}
