package Gisela.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "facttransactions")
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer totalchickens;
}
