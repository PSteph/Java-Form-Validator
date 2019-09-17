# Java Form input Validator
Simple form input validator for your Java application.

### Tests

**validate a name**: should only contain letters and numbers
```java
assertEquals(Validation.validateName("John Doe").isValid(),  true);
```
**validate a phone number**: should only contain 9 numbers and start with number 6
```java
assertEquals(Validation.validatePhoneNumber(678984294l).isValid(),  true);
```
**validate a date of birth**: age should be >=18 
```java
assertEquals(Validation.validateDob(20, 10, 2000).isValid(),  true);
```
**validate a password**
```java
assertEquals(Validation.validatePassword("-John?!Doe021").isValid(),  true);
```

