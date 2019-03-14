package com.crud.kodillalibrary.rent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {
    @Override
    List<Rent> findAll();

    @Override
    Optional<Rent> findById(Long id);

    @Override
    Rent save(Rent rent);


}
