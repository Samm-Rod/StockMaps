package com.stockmap.app.enums;

public enum OrderStatus {

    BUY(1),
    SALE(2);

    private int code;
    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus orders : OrderStatus.values()){
            if(orders.getCode() == code){
                return orders;
            }
        }
        throw new IllegalArgumentException("INVALID TYPE ORDER STATUS CODE ");
    }

}
