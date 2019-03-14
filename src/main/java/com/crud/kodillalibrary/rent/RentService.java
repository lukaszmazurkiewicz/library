package com.crud.kodillalibrary.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {
    private final RentRepository rentRepository;

    @Autowired
    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    List<Rent> getRents() {
        return rentRepository.findAll();
    }

    Rent getRentById(long rentId) {
        return rentRepository.findById(rentId).orElseThrow(RentNotFountException::new);
    }

    Rent addRent(Rent rent) {
        return rentRepository.save(rent);
    }
}
