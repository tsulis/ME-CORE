package com.me.core.model.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private List<String> errors;
    private transient T data;
    private Date serverTime;
}
