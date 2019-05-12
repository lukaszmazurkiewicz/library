package com.crud.kodillalibrary.rent;

import com.crud.kodillalibrary.copy.Status;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class RentService {
    private final RentRepository rentRepository;

    @Transactional
    Rent addRent(Rent rent) {
        rent.getCopy().setStatus(Status.RENTED);

        return rent;
    }

    @Transactional
    Rent returnBook(long id) {
        Rent rent = rentRepository.findById(id).orElseThrow(() -> new RentNotFountException("Rent with id " + id + "not found"));

        rent.setReturnDate(LocalDate.now());
        rent.getCopy().setStatus(Status.AVAILABLE);

        return rent;
    }
}
