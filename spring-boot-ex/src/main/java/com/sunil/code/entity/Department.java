package com.sunil.code.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @NotBlank(message = "Please add department name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
