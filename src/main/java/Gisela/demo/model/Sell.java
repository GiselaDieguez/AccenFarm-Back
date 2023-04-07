package Gisela.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sellproducts")
public class Sell {
    @Id
    private Integer productid;
    private Integer productamt;

}
