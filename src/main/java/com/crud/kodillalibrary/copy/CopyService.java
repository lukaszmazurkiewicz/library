package com.crud.kodillalibrary.copy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CopyService {
    private final CopyRepository copyRepository;

    public Copy getCopyById(long id) {
        return copyRepository.findById(id).orElseThrow(() -> new CopyNotFoundException("Copy with id " + id + " not found."));
    }

    Copy addCopy(Copy copy) {
        return copyRepository.save(copy);
    }

    @Transactional
    Copy changeStatus(Status status, long id) {

        Copy copy = getCopyById(id);
        copy.setStatus(status);

        return copy;
    }

    Long copiesAvailableToRent(long bookId) {

        long howManyCopies = copyRepository.countByBook_IdAndAndStatus(bookId, Status.AVAILABLE);

        return howManyCopies;
    }
}