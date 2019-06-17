package com.amirmemon.npl;

import java.io.Serializable;

public class Input implements Serializable {
    private String input;

    public Input(String input){
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

}
