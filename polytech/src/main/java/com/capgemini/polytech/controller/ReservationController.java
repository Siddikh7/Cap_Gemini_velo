package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.mapper.ReservationMapper;
import com.capgemini.polytech.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/reservations")
public class ReservationController {
    ReservationService reservationService;
    ReservationMapper reservationMapper;

    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper){
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ReservationDTO>> getAllReservations(){
        return ResponseEntity.ok(reservationService.getAllReservations()
                .stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/id")
    @ResponseBody
    public ResponseEntity<ReservationDTO> getReservationById(@RequestParam int id){
        return ResponseEntity.ok(
                reservationMapper.toDTO(
                        reservationService.findById(id)));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO){
        return ResponseEntity.ok(
                reservationMapper.toDTO(
                        reservationService.createReservation(
                                reservationMapper.toEntity(reservationDTO))));
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<ReservationDTO> updateReservation(@RequestParam int id, @RequestBody ReservationDTO reservationDTO){
        return ResponseEntity.ok(
                reservationMapper.toDTO(
                        reservationService.updateReservation(id, reservationMapper.toEntity(reservationDTO))));
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> deleteReservation(@RequestParam int id){
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.ok("reservation bien supp");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("erreur : flm");
        }
    }
}
