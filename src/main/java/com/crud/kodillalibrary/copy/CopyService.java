package com.crud.kodillalibrary.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    Copy getCopyById(long id) {
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

    List<Copy> copiesAvailableToRent() {
        List<Copy> copies = copyRepository.findAll();
        return copies.stream()
                .filter(c -> c.getStatus().equals("ok"))
                .collect(Collectors.toList());
    }
}