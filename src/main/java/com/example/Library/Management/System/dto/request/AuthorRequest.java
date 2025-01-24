package com.example.Library.Management.System.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorRequest {

    @NotBlank(message = "First name can not be empty")
     String firstName;
    @NotBlank(message = "Last name can not be empty")
     String lastName;
    LocalDate birthDate;
    @Size(max = 256, message = "Must be a maximum of 256 characters ")
     String about;
}
