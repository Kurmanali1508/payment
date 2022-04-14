package com.example.payment.exception;

public class PaymentIsCancelled extends RuntimeException {
    public PaymentIsCancelled(String message) {
        super(message);
    }
}