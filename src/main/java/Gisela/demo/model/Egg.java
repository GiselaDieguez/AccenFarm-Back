package Gisela.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productsbuy")
public class Egg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productid;

}
