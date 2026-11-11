package services;

import enums.Type;

import java.time.Duration;

// Fee calculation should be based on duration and type of vehicle:
// Car - Rs 60 per hour
// Bike - Rs 30 per hour
// Truck - Rs 120 per hour
public class StandardFeeCalculationStrategy implements FeeCalculationStrategy{
    double CAR_HOURLY_RATE = 60;
    double BIKE_HOURLY_RATE = 30;
    double TRUCK_HOURLY_RATE = 120;
    @Override
    public double calculateFees(Duration duration, Type slotType) {
        long durationInMinutes = (duration.toHours()*60) + (duration.toMinutes() % 60);
        double costPerMinute = 0;
        switch (slotType){
            case CAR -> {
                costPerMinute = CAR_HOURLY_RATE / 60;
                return durationInMinutes * costPerMinute;
            }
            case BIKE -> {
                costPerMinute = BIKE_HOURLY_RATE / 60;
                return durationInMinutes * costPerMinute;
            }
            case TRUCK -> {
                costPerMinute = TRUCK_HOURLY_RATE / 60;
                return durationInMinutes * costPerMinute;
            }
            default -> {
                return 0;
            }
        }
    }
}
