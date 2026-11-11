package services;

import enums.Type;

import java.time.Duration;

public interface FeeCalculationStrategy {
    double calculateFees(Duration duration, Type slotType);
}
