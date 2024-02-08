package com.pugapa.practiceproject;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
