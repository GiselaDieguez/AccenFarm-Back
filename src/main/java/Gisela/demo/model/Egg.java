package Gisela.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "factproducts")
public class Egg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productid;
    private Long datekey;
    private Long productamt;


}
