package com.appcoy.ace.api.util;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true)
public class BaseResponse<T>{
    private boolean status;
    private String message;
    private T data;

    private static final boolean OK = true;
    private static final boolean FAIL = false;

    static class BaseResponseMessage {
        public static final String SUCCESS = "Successful";
        public static final String UNSUCCESSFUL = "Unsuccessful";
    }

    public static<T> BaseResponse ok(String message) {
        return ok(message, null);
    }
    public static<T> BaseResponse ok(T data) {
        return ok(BaseResponseMessage.SUCCESS, data);
    }
    public static<T> BaseResponse ok(String message, T data) {
        return new BaseResponse(OK, message, data);
    }

    public static<T> ResponseEntity<BaseResponse<T>> okResponse(T data) {
        return ResponseEntity.ok(ok(data));
    }

    public static<T> ResponseEntity<BaseResponse<T>> okResponse(String message) {
        return ResponseEntity.ok(ok(message));
    }
}