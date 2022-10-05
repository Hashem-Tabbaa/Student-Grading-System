package com.atypon.studentgradingsystemspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class Statistics implements Serializable {

    private String statisticType;
    private Double value;

    public Statistics() {

    }
}
