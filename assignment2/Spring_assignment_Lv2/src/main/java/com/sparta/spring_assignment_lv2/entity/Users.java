package com.sparta.spring_assignment_lv2.entity;

import com.sparta.spring_assignment_lv2.dto.RegisterRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String email;

    public Users(RegisterRequestDto registerRequestDto) {
        this.userId = registerRequestDto.getUserid();
        this.password = registerRequestDto.getPassword();
        this.userName = registerRequestDto.getUsername();
        this.email = registerRequestDto.getEmail();
    }
}
