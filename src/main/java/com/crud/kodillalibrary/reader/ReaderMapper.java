package com.crud.kodillalibrary.reader;

import org.springframework.stereotype.Service;

@Service
class ReaderMapper {
    Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstName(),
                readerDto.getLastName(),
                readerDto.getCreateAccountDate());
    }
}