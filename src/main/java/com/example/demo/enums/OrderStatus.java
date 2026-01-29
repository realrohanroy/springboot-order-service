package com.example.demo.enums;

public enum OrderStatus {
    CREATED,
    PAID,
    CANCELLED,
    DELIVERED;

    public boolean canTransitionTo(OrderStatus nextStatus){

        return switch(this){
            case CREATED ->
                    nextStatus == PAID || nextStatus == CANCELLED;

            case PAID ->
                    nextStatus == DELIVERED;

            case DELIVERED, CANCELLED ->
                    false;
        };
    }
}
