package com.bl.exceptions;

public class UserNotFoundException extends IllegalArgumentException{
    private String msg;

    public UserNotFoundException(String msg){
        super(msg);
        this.msg = msg;
    }
}
