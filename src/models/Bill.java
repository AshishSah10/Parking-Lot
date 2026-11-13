package models;

import enums.PaymentStatus;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class Bill extends BaseEntity{
    // in hours
    private Duration duration;
    private double amount;
    private final LocalDateTime exitTime;
    private PaymentStatus paymentStatus;

    private final Long ticketId;

    public Bill(Long ticketId, LocalDateTime exitTime, Duration duration, double amount, PaymentStatus paymentStatus) {
        this.ticketId = ticketId;
        this.exitTime = exitTime;
        this.amount = amount;
        this.duration = duration;
        this.paymentStatus = paymentStatus;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }
}
