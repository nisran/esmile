package com.esmile.common.base;

import com.esmile.common.constant.HttpCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResult<T> {

    private Boolean success;
    private String code;
    private String msg;
    private T data;

    public static GenericResult Success() {
        return new GenericResult(Boolean.TRUE, HttpCode.SUCCESS, null, null);
    }
    public static GenericResult SuccessData(Object data) {
        return new GenericResult(Boolean.TRUE, HttpCode.SUCCESS, null, data);
    }


    public static GenericResult SuccessMsg(String msg) {
        return new GenericResult(Boolean.TRUE, HttpCode.SUCCESS, msg, null);
    }

}
