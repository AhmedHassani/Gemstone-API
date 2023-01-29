package com.ahd.gemstone.models;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
    boolean success;

    List<T> body = new ArrayList<T>();
    String message;
    int code;

    public Response() {
    }

    public Response(boolean success, List<T> body, String message, int code) {
        this.success = success;
        this.body = body;
        this.message = message;
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<T> getBody() {
        return body;
    }

    public void setBody(List<T> body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
