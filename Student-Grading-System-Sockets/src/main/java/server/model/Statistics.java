package server.model;

import java.io.Serializable;

public class Statistics implements Serializable {

    private String statisticType;
    private Double value;

    public Statistics(String statisticType, Double value) {
        this.statisticType = statisticType;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Statistic Type='" + statisticType + '\'' +
                "        value=" + value;
    }
}
