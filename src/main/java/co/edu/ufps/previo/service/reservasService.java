package co.edu.ufps.previo.service;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class reservasService {


    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private HabitacionService habitacionService;

    public Reserva crearReserva(Long clienteId, Long habitacionId, LocalDate fechaInicio, LocalDate fechaFin) {
        Cliente cliente = clienteService.obtenerClientePorId(clienteId);
        Habitacion habitacion = habitacionService.obtenerHabitacionPorId(habitacionId);

        if (cliente == null || habitacion == null || !habitacion.isDisponible()) {
            return null;
        }

        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setHabitacion(habitacion);
        reserva.setFechaInicio(fechaInicio);
        reserva.setFechaFin(fechaFin);

        habitacion.setDisponible(false);
        habitacionService.actualizarHabitacion(habitacionId, habitacion);

        return reservaRepository.save(reserva);
    }

    public Reserva obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> obtenerReservasPorCliente(Long clienteId) {
        return reservaRepository.findByClienteId(clienteId);
    }

    public List<Reserva> obtenerReservasPorHabitacion(Long habitacionId) {
        return reservaRepository.findByHabitacionId(habitacionId);
    }

    public Reserva actualizarFechasReserva(Long id, LocalDate nuevaFechaInicio, LocalDate nuevaFechaFin) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva != null) {
            reserva.setFechaInicio(nuevaFechaInicio);
            reserva.setFechaFin(nuevaFechaFin);
            return reservaRepository.save(reserva);
        }
        return null;
    }

    public void cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva != null) {
            reserva.setActiva(false);
            Habitacion habitacion = reserva.getHabitacion();
            habitacion.setDisponible(true);
            habitacionService.actualizarHabitacion(habitacion.getId(), habitacion);
            reservaRepository.save(reserva);
        }
    }

    public double calcularCostoReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva != null) {
            long dias = ChronoUnit.DAYS.between(reserva.getFechaInicio(), reserva.getFechaFin());
            return dias * reserva.getHabitacion().getPrecio();
        }
        return 0;
    }

    public List<reservas> obtenerReservasRecientes(int dias) {
        LocalDate fechaLimite = LocalDate.now().minusDays(dias);
        return reservaRepository.findByFechaInicioAfter(fechaLimite);
    }

    public List<Habitacion> obtenerHabitacionesDisponibles(LocalDate inicio, LocalDate fin, int capacidad) {
        // Implementar lógica para verificar disponibilidad en el rango de fechas
        return habitacionService.obtenerHabitacionesDisponibles()
                .stream()
                .filter(h -> h.getCapacidad() >= capacidad)
                .toList();
    }
}