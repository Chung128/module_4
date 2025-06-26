package com.example.form_input.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class Use implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phone;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Use use=(Use) target;
        if (use.getFirstName().isEmpty()){
            errors.rejectValue("firstName","empty");
        }else if (!use.getFirstName().matches("^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$")){
            errors.rejectValue("firstName","regexName");
        }else if (use.getFirstName().length()<5||use.getFirstName().length()>45){
            errors.rejectValue("firstName","lengthName");
        }

        if (use.getLastName().isEmpty()){
            errors.rejectValue("lastName","empty");
        }else if (!use.getLastName().matches("^[A-Z][a-z]*$")){
            errors.rejectValue("lastName","regexName");
        }else if (use.getLastName().length()<5||use.getLastName().length()>45){
            errors.rejectValue("lastName","lengthName");
        }

        if (use.getAge()==null){
            errors.rejectValue("age","empty");
        }else if (use.getAge()<18){
            errors.rejectValue("age","regexAge");
        }

        if (use.getPhone().isEmpty()){
            errors.rejectValue("phone","empty");
        }else if (!use.getPhone().matches("^[0][0-9]{9}$")){
            errors.rejectValue("phone","regexPhone");
        }

        if (use.getEmail().isEmpty()){
            errors.rejectValue("email","empty");
        }else if (!use.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")){
            errors.rejectValue("email","regexEmail");
        }
    }
}
