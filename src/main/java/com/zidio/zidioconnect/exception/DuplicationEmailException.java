package com.zidio.zidioconnect.exception;

public class DuplicationEmailException extends RuntimeException {

    public DuplicationEmailException(String email) {
        super("Email already exists: " + email); // ✅ Now email is actually used
    }
}
