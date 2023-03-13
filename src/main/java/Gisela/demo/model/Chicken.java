package Gisela.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "factproducts")
public class Chicken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productid;
    private Long activeind;

}
