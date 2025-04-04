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

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    private Reserva reserva;

    public void createRoom(String type, double price, int capacity) {

    }

    public void getRoomById(Long id){

    }

    public void getAllRooms(){

    }

    public void updateRoom(Long id, String type, double price, int capacity) {

    }

    public void deleteRoom(Long id) {

    }
}
