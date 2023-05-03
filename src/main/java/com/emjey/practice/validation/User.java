package com.emjey.practice.validation;

import com.emjey.practice.validation.validation.Age;
import com.emjey.practice.validation.validation.Username;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {

    @NotBlank(message = "First name can't be blank")
    @Size(min = 4, message = "First name is too short")
    private String firstName;

    @NotBlank(message = "Last name can't be blank")
    @Size(min = 2, message = "Last name is too short")
    private String lastName;

    @NotBlank(message = "User name can't be blank")
    @Size(min = 7, message = "User name is too short")
    @Username(message = "Cannot contain special characters or uppercase characters ")
    private String userName;

    @Email(message = "Email is not valid")
    private String email;

    @Past(message = "The date should be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Age(message = "Must be at least 18")
    private Date dateOfBirth;

    public User(String firstName, String lastName, String userName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
