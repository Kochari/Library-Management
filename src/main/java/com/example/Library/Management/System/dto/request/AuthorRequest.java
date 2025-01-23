package com.example.Library.Management.System.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorRequest {

    @NotBlank(message = "First name can not be empty")
    private String firstName;
    @NotBlank(message = "Last name can not be empty")
    private String lastName;
    LocalDate birthDate;
    @Size(max = 256, message = "Must be a maximum of 256 characters ")
    private String about;
}
