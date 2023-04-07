package Gisela.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "deleteproducts")
public class Delete {
    @Id
    private Integer productid;
    private Integer productamt;
}
