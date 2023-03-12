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
    private Long transactionid;
    private Time time;
    private Long productid;
    private Long transactionamt;
}
