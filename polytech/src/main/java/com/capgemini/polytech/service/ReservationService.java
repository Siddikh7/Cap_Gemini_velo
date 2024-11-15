package com.capgemini.polytech.service;


import com.capgemini.polytech.entity.Reservation;
import com.capgemini.polytech.entity.ReservationId;
import com.capgemini.polytech.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public Reservation createReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public Reservation findById(ReservationId reservationId){
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if (optionalReservation.isPresent()) {
            return optionalReservation.get();
        } else {
            throw new NoSuchElementException("ce reservation n'existe pas");
        }
    }

    public Reservation updateReservation(ReservationId reservationId, Reservation reservation){
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if(optionalReservation.isPresent()){
            Reservation existingReservation = optionalReservation.get();
            existingReservation.setReservation(reservation.getReservation());
            return reservationRepository.save(existingReservation);
        }else{
            throw new NoSuchElementException("ce reservation n'existe pas");
        }
    }

    public void deleteReservation(ReservationId reservationId){
        if(!reservationRepository.existsById(reservationId)){
            throw new NoSuchElementException("ce reservation n'existe pas");
        }
        reservationRepository.deleteById(reservationId);
    }
}
