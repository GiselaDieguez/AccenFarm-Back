package Gisela.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "facttransactions")
public class Cash {
    @Id
    private Long totalcash;
}
