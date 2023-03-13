package Gisela.demo.model;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Data
@Entity
@Table(name = "facttransactions")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Time time;
    private String productnm;
    private Long transactionamt;
    private String transactionnm;
}
