package com.stockmap.app.enums;

public enum TypeAssets {

    BONDS(1),
    ETF(2),
    STOCKS(3);

    private int code;

    private TypeAssets(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TypeAssets valueOf(int code){
        for(TypeAssets types : TypeAssets.values()){
            if(types.getCode() == code){
                return types;
            }
        }
        throw new IllegalArgumentException("INVALID TYPE ASSETS CODE ");
    }

}
