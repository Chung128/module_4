package com.example.thong_tin_bai_hat.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "song")
public class Song implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String name;
    private  String artist;
    private  String genre;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song= (Song) target;
        if (song.getName().isEmpty()){
            errors.rejectValue("name","empty");
        }else if (!song.getName().matches("^[a-zA-Z0-9 ]+$")){
            errors.rejectValue("name","regex");
        }else if (song.getName().length()>800){
            errors.rejectValue("name","length");
        }

        if (song.getArtist().isEmpty()){
            errors.rejectValue("artist","empty");
        }else if (!song.getArtist().matches("^[a-zA-Z0-9 ]+$")){
            errors.rejectValue("artist","regex");
        }else if (song.getArtist().length()>300){
            errors.rejectValue("artist","length");
        }


        if (song.getGenre().isEmpty()){
            errors.rejectValue("genre","empty");
        }else if (!song.getGenre().matches("^[^,]+$")){
            errors.rejectValue("genre","regexGenre");
        }else if (song.getGenre().length()>1000){
            errors.rejectValue("genre","length");
        }
    }
}
