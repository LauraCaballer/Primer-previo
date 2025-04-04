package co.edu.ufps.previo.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;



    public void createReservation(Long customerId, Long roomId, LocalDate startDate, LocalDate endDate) {

    }

    public void getReservationById(Long reservationId) {

    }

    public void getReservationByCustomer(Long customerId) {

    }

    public void getReservationByRoom(Long roomId) {}

    public void updateReservationDates(Long reservationId, LocalDate newStartDate, LocalDate newEndDate) {

    }

    public void cancelReservation(Long reservationId) {}
}
