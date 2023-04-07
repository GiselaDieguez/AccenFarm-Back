package Gisela.demo.model;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "facttransactions")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Timestamp time;
    private String productnm;
    private Integer productprice;
    private Integer transactionamt;

}
