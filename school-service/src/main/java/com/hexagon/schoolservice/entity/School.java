package com.hexagon.schoolservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity                 // diz ao JPA que essa classe vira uma tabela
@Table(name = "school") // nome da tabela no MySQL
@Data                   // Lombok: cria getters, setters, toString...
@NoArgsConstructor      // Lombok: construtor vazio (o JPA exige)
@AllArgsConstructor     // Lombok: construtor com todos os campos
public class School {

    @Id                                                  // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto incremento do MySQL
    private Integer id;

    private String schoolName;
    private String location;
    private String principalName;
}