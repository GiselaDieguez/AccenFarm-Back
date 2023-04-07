package Gisela.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "buyproducts")
public class Buy {
    @Id
    private Integer productid;
    private Integer productamt;

}
