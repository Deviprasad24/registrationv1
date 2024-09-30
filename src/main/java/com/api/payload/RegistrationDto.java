package com.api.payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegistrationDto {

    @Size(min=2,message = "min should be 2 letters")
    private String name;
    @Email(message = "email should be in the valid format")
    private String email;
    @Size(min=10,max = 10,message = "number should be 10 digits")
    private String mobile;

}