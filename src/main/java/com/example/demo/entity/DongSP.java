package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "dong_sp")
public class DongSP {
    @Id
    @Column(length = 32)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public DongSP(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    private String ma;
    private String ten;
}
