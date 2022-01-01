package com.system.farecard.pojo;

public class ErrorResponse {
    private String error;
    private String errorDesc;

    public ErrorResponse(String error, String errorDesc) {
        this.error = error;
        this.errorDesc = errorDesc;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }
}
