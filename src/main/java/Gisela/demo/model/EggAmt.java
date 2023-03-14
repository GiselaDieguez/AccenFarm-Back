package Gisela.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productsbuy")

public class EggAmt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long totaleggs;
}
