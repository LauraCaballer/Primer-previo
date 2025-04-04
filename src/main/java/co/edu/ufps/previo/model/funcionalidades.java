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


    public void checkRoomAvailability(Long roomId, LocalDate startDate, LocalDate endDate) {

    }

    public void getAvailableRooms(LocalDate startDate, LocalDate endDate, int capacity) {

    }

    public void getRecentReservations(int days){

    }

    public void calculateReservationCost(Long reservationId){

    }
}
