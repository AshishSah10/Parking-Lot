package models;

import enums.PaymentStatus;

import java.util.Date;

public class Bill extends BaseEntity{
    // in hours
    private double duration;
    private double amount;
    private final Date exitTime;
    private PaymentStatus paymentStatus;

    private final Long ticketId;

    public Bill(Long ticketId, Date exitTime, double duration, double amount, PaymentStatus paymentStatus) {
        this.ticketId = ticketId;
        this.exitTime = exitTime;
        this.amount = amount;
        this.duration = duration;
        this.paymentStatus = paymentStatus;
    }

    public Bill(Date exitTime, Long ticketId, PaymentStatus paymentStatus) {
        this.exitTime = exitTime;
        this.ticketId = ticketId;
        this.paymentStatus = paymentStatus;
    }

    public Bill(Date exitTime, Long ticketId) {
        this.exitTime = exitTime;
        this.ticketId = ticketId;
        this.paymentStatus = PaymentStatus.UNPAID;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
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

    public Date getExitTime() {
        return exitTime;
    }
}
