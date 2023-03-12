package Gisela.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chicken")
public class Chicken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long buyprice;
    private Long sellprice;
    private Long activeind;
    private String state;

}
