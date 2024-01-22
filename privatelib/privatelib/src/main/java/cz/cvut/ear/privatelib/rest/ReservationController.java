package cz.cvut.ear.privatelib.rest;

import cz.cvut.ear.privatelib.model.Cart;
import cz.cvut.ear.privatelib.model.Reservation;
import cz.cvut.ear.privatelib.service.ReservationService;
import cz.cvut.ear.privatelib.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    private final UserService userService;


    public ReservationController(ReservationService reservationService, UserService userService) {
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createReservation() {
        final Reservation reservation = reservationService.create();
        final HttpHeaders headers = RestUtils.createLocationHeaderFromCurrentUri("/{id}", reservation.getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    // только юзер которьій сделал и админ
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reservation getReservation(@PathVariable Integer id) {
        final Reservation reservation = reservationService.find(id);
        if (reservation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found");
        }
        return reservation;
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteReservation(@PathVariable Integer id) {
        Reservation reservation = reservationService.find(id);
        if (reservation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found");
        }
        reservationService.delete(reservation);
    }

}
