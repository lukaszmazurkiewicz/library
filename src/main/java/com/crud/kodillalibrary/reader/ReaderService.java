package com.crud.kodillalibrary.reader;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;

    public Reader getReaderById(long id) {
        return readerRepository.findById(id).orElseThrow(() -> new ReaderNotFindException("Reader with id " + id + "not found"));
    }

    Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }
}
