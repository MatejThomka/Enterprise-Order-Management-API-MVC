package com.mth.spring.mvc.ordermanagement.model;

import org.springframework.data.annotation.Id;

public record Item(@Id Long id, String name, String description) {}
