package com.p2sdev.validator;

public class ValidationMessage {

    private boolean isValid;
    private ValidationStatus status;

    public ValidationMessage(){
        this(false, ValidationStatus.INVALID);
    }

    public ValidationMessage(boolean isValid, ValidationStatus status) {
        this.isValid = isValid;
        this.status = status;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public void setStatus(ValidationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ValidationMessage{" +
                "isValid=" + isValid +
                ", status=" + status +
                '}';
    }
}

