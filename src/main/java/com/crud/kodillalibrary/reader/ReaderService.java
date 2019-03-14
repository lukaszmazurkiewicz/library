package com.crud.kodillalibrary.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    List<Reader> getReaders() {
        return readerRepository.findAll();
    }

    public Reader getReaderById(long id) {
        return readerRepository.findById(id).orElseThrow(ReaderNotFindException::new);
    }

    Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }
}
