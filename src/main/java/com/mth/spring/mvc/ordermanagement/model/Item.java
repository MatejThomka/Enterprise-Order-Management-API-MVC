package com.mth.spring.mvc.ordermanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "items")
public record Item(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,
    @Column(nullable = false) String name,
    @Column(nullable = false) String description,
    BigDecimal price,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "order_id") Order order) {}
