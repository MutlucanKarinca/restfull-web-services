package com.mutlucankarinca.rest.webservices.restfullwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    private Date timestamp;
    private String message;
    private String details;

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
