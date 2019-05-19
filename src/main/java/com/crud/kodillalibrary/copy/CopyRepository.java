package com.crud.kodillalibrary.copy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {
    @Override
    List<Copy> findAll();

    @Override
    Optional<Copy> findById(Long id);

    @Override
    Copy save(Copy copy);

    Long countByBook_IdAndAndStatus(long bookId, Status status);
}