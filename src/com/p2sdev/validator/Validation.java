package com.p2sdev.validator;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * @Author: Stephane Piedjou
 *
 */
public class Validation {

    // Should start with an alphabetical character, should be 3 to 29 characters long
    // and should only contain alphanumerical characters, _ and .
    private final static String regexUname = "^[a-zA-ZÀ-Æà-æÈ-Ëè-ëÌ-Ïì-ïÒ-Øò-øÙ-Üù-üÑñÇç][\\w.À-Æà-æÈ-Ëè-ëÌ-Ïì-ïÒ-Øò-øÙ-Üù-üÑñÇç]{3,50}";
    private static Pattern unamePatter = Pattern.compile(regexUname);

    private final static String regexPassword = "[\\w.$\\-\\+=!?À-Æà-æÈ-Ëè-ëÌ-Ïì-ïÒ-Øò-øÙ-Üù-üÑñÇç]{3,50}";
    private static Pattern passPattern = Pattern.compile(regexPassword);

    private final static String regexName = "[a-zA-Z0-9À-Æà-æÈ-Ëè-ëÌ-Ïì-ïÒ-Øò-øÙ-Üù-üÑñÇç\\s]{3,50}";
    private static Pattern namePatter = Pattern.compile(regexName);

    // Cameroon: without the country code the phone number is 9 characters long in total,
    // the first character being 6
    private static Pattern phonePattern = Pattern.compile("^[6]\\d{8}");

    private static final int MIN_AGE = 18;

    /**
     *
     * @param username
     * @return ValidationMessage
     */
    public static ValidationMessage validateUsername(String username){

        if(username == null || username.isEmpty())
            return new ValidationMessage(false, ValidationStatus.EMPTYORNULL);

        if(unamePatter.matcher(username).matches())
            return new ValidationMessage(true, ValidationStatus.VALIDUSERNAME);

        return new ValidationMessage(false, ValidationStatus.INVALIDUSERNAME);
    }

    /**
     *
     * @param password
     * @return
     */
    public static ValidationMessage validatePassword(String password){

        if(password == null || password.isEmpty())
            return new ValidationMessage(false, ValidationStatus.EMPTYORNULL);

        if(passPattern.matcher(password).matches())
            return new ValidationMessage(true, ValidationStatus.VALIDPASSWORD);

        return new ValidationMessage(false, ValidationStatus.INVALIDPASSWORD);
    }

    /**
     *
     * @param name
     * @return
     */
    public static ValidationMessage validateName(String name){
        if(name == null || name.isEmpty())
            return new ValidationMessage(false, ValidationStatus.EMPTYORNULL);

        if(namePatter.matcher(name).matches())
            return new ValidationMessage(true, ValidationStatus.VALIDNAME);

        return new ValidationMessage(false, ValidationStatus.INVALIDNAME);
    }

    /**
     *
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static ValidationMessage validateDob(int day, int month, int year){

        try{
            LocalDate dob = LocalDate.of(year, month, day);
            int age = (LocalDate.now().getYear()-dob.getYear());
            if( age < MIN_AGE ){
                return new ValidationMessage(false, ValidationStatus.DOBTOOYOUNG);
            }else{
                return new ValidationMessage(true, ValidationStatus.VALIDDOB);
            }
        }catch(Exception e){
            return new ValidationMessage(false, ValidationStatus.INVALIDDATE);
        }

    }

    /**
     *
     * @param phoneNumber
     * @return
     */
    public static ValidationMessage validatePhoneNumber(Long phoneNumber){

        if(phoneNumber.toString().isEmpty() || phoneNumber.toString() == null)
            return new ValidationMessage(false, ValidationStatus.EMPTYORNULL);

        if(phonePattern.matcher(phoneNumber.toString()).matches() )
            return new ValidationMessage(true, ValidationStatus.VALIDPHONENUMBER);

        return new ValidationMessage(false, ValidationStatus.INVALIDPHONENUMBER);
    }
}
