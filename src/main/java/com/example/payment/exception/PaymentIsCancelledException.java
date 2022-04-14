package com.example.payment.exception;

public class PaymentIsCancelledException extends RuntimeException {
    public PaymentIsCancelledException(String message) {
        super(message);
    }
}