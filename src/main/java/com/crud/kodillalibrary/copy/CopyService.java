package com.crud.kodillalibrary.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyService {
    private final CopyRepository copyRepository;

    @Autowired
    public CopyService(CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }

    List<Copy> getCopies() {
        return copyRepository.findAll();
    }

    public Copy getCopyById(long id) {
        return copyRepository.findById(id).orElseThrow(CopyNotFoundException::new);
    }

    Copy addCopy(Copy copy) {
        return copyRepository.save(copy);
    }

    Copy changeStatus(CopyDto copyDto, long id) {
        Copy copy = copyRepository.findById(id).orElseThrow(CopyNotFoundException::new);
        copy.setStatus(copyDto.getStatus());
        return copyRepository.save(copy);
    }

    Long copiesAvailableToRent(long bookId) {
        long howManyCopies = copyRepository.countByBook_IdAndAndStatus(bookId, Status.AVAILABLE);

        return howManyCopies;
    }
}