package com.example.studentfeign.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private String firstName;
    private String lastName;
    @Id
    private String studentNumber;
    private String school;
    private String classOf;
    private int score;
    HashMap<String, Integer> rewards;

}