package cz.cvut.ear.privatelib.dao;

import cz.cvut.ear.privatelib.model.Genre;
import cz.cvut.ear.privatelib.model.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDao extends AbstractDao<Reservation>{
    public ReservationDao() {
        super(Reservation.class);
    }
}
