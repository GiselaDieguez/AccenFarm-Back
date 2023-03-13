package Gisela.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "factproducts")
public class ProductsAmt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer productamt;

}
