package Gisela.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "newproducts")
public class Birth {
    @Id
    private Integer productid;
}
