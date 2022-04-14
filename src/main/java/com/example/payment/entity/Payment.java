package com.example.payment.entity;

import com.example.payment.entity.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @OneToOne
    private Client client;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}