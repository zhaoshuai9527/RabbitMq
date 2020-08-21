package com.MQ;

public class Result {
    private Boolean success;
    private String message;
    private Object date;

    public Result(Boolean success, String message, Object date) {
        this.success = success;
        this.message = message;
        this.date = date;
    }

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public Result() {

    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
