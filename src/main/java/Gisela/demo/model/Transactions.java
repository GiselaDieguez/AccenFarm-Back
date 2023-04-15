package Gisela.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dimtrasactiontype")
public class Transactions {
    @Id
    private Integer productid;
    private Integer productamt;

}
