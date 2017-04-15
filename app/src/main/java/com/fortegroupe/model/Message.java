package com.fortegroupe.model;

/**
 * Created by alex on 13.4.17.
 */
public class Message {
    private String userEmail;
    private boolean hasError;
    private String Message;

    public Message() {
    }

    public Message(String userEmail, boolean hasError, String message) {
        this.userEmail = userEmail;
        this.hasError = hasError;
        Message = message;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
