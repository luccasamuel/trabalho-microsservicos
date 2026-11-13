package com.hexagon.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDTO {
    private Integer id;
    private String schoolName;
    private String location;
    private String principalName;
}