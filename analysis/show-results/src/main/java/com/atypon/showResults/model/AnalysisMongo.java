package com.atypon.showResults.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AnalysisMongo {

    @Id
    private String _id;
    private String analysis_type;
    private Double value;

    public AnalysisMongo(String analysis_type, Double value) {
        this.analysis_type = analysis_type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "AnalysisMongo{" +
                ", analysis_type='" + analysis_type + '\'' +
                ", value=" + value +
                '}';
    }
}
