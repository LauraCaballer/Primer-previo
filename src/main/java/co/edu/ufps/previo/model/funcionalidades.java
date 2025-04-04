package co.edu.ufps.previo.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class funcionalidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    Long roomId;




}
