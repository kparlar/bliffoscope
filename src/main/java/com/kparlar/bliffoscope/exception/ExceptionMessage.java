package com.kparlar.bliffoscope.exception;

import java.util.ArrayList;
import java.util.List;

public class ExceptionMessage {
    private List<String> errors;
    public ExceptionMessage() {
        this.setErrors(new ArrayList<>());
    }
    public List<String> getErrors() {
            return this.errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }


}
