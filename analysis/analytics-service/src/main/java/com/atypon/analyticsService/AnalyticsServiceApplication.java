package com.atypon.analyticsService;

import com.atypon.analyticsService.service.StoreAnalysisService;
import com.atypon.analyticsService.service.TemperatureAnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@AllArgsConstructor
public class AnalyticsServiceApplication implements CommandLineRunner {

    private final TemperatureAnalysisService temperatureAnalysisService;
    private final StoreAnalysisService storeAnalysisService;

    public static void main(String[] args) {
        System.out.println("Starting Analytics Service 1.6");
        SpringApplication.run(AnalyticsServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        while (true){
            Double average = temperatureAnalysisService.getAverageTemperature();
            Double max = temperatureAnalysisService.getMaxTemperature();
            Double min = temperatureAnalysisService.getMinTemperature();
            System.out.println("Average: " + average + " Max: " + max + " Min: " + min);

            try{
                storeAnalysisService.storeAnalysis("average", average, "1");
                storeAnalysisService.storeAnalysis("max", max, "2");
                storeAnalysisService.storeAnalysis("min", min, "3");
            }catch (Exception e){
                System.out.println("Error storing analysis");
                e.printStackTrace();
            }

            Thread.sleep(5000);
        }
    }
}
