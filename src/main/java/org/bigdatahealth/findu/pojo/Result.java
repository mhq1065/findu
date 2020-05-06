package org.bigdatahealth.findu.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
public class Result{


    private int retCode;

    private String message;

    private Map data;

    public Result(int retCode, String message) {
        this.retCode = retCode;
        this.message = message;
    }

    public Result(){}

    @Override
    public String toString() {
        return "Result{" +
                "retCode=" + retCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }


}
