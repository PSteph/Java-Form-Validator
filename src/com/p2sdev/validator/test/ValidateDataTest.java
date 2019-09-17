package com.p2sdev.validator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.p2sdev.validator.Validation;

public class ValidateDataTest {
    @Test
    public void validate_username(){ assertEquals(Validation.validateUsername("John.Doe").isValid(), true); }
    @Test
    public void validate_phoneNumber(){ assertEquals(Validation.validatePhoneNumber(678984294l).isValid(),  true); }
    @Test
    public void validate_DoB(){ assertEquals(Validation.validateDob(20, 10, 2000).isValid(),  true); }
    @Test
    public void validate_Password(){ assertEquals(Validation.validatePassword("-John?!Doe021").isValid(),  true); }
    @Test
    public void validate_Name(){ assertEquals(Validation.validateName("John Doe").isValid(),  true); }
}
