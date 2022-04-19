package com.example.spocktestinghomework.dao.entity;


import com.example.spocktestinghomework.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Setter
@Getter
public class DeveloperEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String username;
    private Integer age;

    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;


    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
