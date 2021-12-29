package com.esmile.common.base;

import lombok.Data;

import static com.esmile.common.constant.GlobalConstant.SUCCESS_CODE;
import static com.esmile.common.constant.GlobalConstant.SUCCESS_MSG;

@Data
public class ResultMessage<T> {

    private String code;
    private String msg;
    private T data;


    public static ResultMessage SuccessResult() {
        return new ResultMessage(SUCCESS_CODE, SUCCESS_MSG);
    }


    // static方法为什么不能用泛型泛型参数。
    public static ResultMessage SuccessResult(Object data) {
        ResultMessage resultMessage = ResultMessage.SuccessResult();
        resultMessage.setData(data);
        return resultMessage;
    }

    private ResultMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
