package com.appcoy.ace.api.util;
import org.springframework.http.ResponseEntity;

public class BaseResponse <T> {
    private boolean status;
    private String message;
    private T data;
    private static final boolean OK = true;
    private static final boolean FAIL = false;

    static class BaseResponseMessage {
        private static final String OK = "Successful";
        private static final String FAIL = "Successful";
    }
    private BaseResponse(boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static<T> BaseResponse ok() {
        return ok(BaseResponseMessage.OK);
    }

    public static<T> BaseResponse ok(T data) {
        return ok(BaseResponseMessage.OK, data);
    }

    public static<T> BaseResponse ok(String message) {
        return ok(message, null);
    }

    public static<T> BaseResponse ok (String message, T data) {
        return new BaseResponse(OK, message, data);
    }

    public static <T> BaseResponse fail() {
        return fail(BaseResponseMessage.FAIL);
    }
    public static <T> BaseResponse fail(String message) {
        return fail(message, null);
    }

    public static <T> BaseResponse fail(String message, T data) {
        return new BaseResponse(FAIL, message, data);
    }

    public static<T> ResponseEntity<BaseResponse<T>> okResponse() {
        return ResponseEntity.ok().body(BaseResponse.ok());
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
