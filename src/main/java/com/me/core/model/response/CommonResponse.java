package com.me.core.model.response;

import com.me.core.constant.enums.ResponseCode;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CommonResponse {

    public CommonResponse() {
    }

    public static <T> BaseResponse<T> constructResponse(ResponseCode responseCode, T data) {
        return new BaseResponse.BaseResponseBuilder<T>()
            .code(responseCode.getCode())
            .message(responseCode.getMessage())
            .errors(Collections.emptyList())
            .serverTime(new Date())
            .data(data)
            .build();
    }

    public static <T> BaseResponse<T> constructResponse(ResponseCode responseCode, List<String> errors, T data) {
        return new BaseResponse.BaseResponseBuilder<T>()
            .code(responseCode.getCode())
            .message(responseCode.getMessage())
            .errors(errors)
            .serverTime(new Date())
            .data(data)
            .build();
    }
}
