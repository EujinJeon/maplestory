package com.example.maplestory.domain.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "character_name",unique = true, nullable = false)
    private String characterName;

    @Column(unique = true, nullable = false)
    private String ocid;
}
