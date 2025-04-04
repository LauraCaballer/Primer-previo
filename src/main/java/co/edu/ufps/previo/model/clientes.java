package co.edu.ufps.previo.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nombre;
    String email;
    String phoneNumber;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<reservas> reservas;


}
