package com.cts.exception;


public class InvalidChoiceException extends Exception {        //Creating a User-Defined Exception
    public InvalidChoiceException(String message) {
        super(message);                                       //calls the constructor of the superclass
    }
}
