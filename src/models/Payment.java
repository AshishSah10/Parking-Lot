package models;

import enums.PaymentMode;
import enums.PaymentStatus;

public class Payment extends BaseEntity{
    private final Long paymentId;

    private final Long billId;

    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;

    public Payment(Long paymentId, Long billId, PaymentMode mode, PaymentStatus status) {
        this.paymentId = paymentId;
        this.billId = billId;
        this.paymentMode = mode;
        this.paymentStatus = status;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public Long getBillId() {
        return billId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
