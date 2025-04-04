package co.edu.ufps.previo.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class habitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String type;
    private double price;
    private int capacity;



}
