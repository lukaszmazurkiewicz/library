package com.crud.kodillalibrary.rent;

import com.crud.kodillalibrary.copy.Copy;
import com.crud.kodillalibrary.copy.CopyService;
import com.crud.kodillalibrary.reader.Reader;
import com.crud.kodillalibrary.reader.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RentMapper {
    private final ReaderService readerService;
    private final CopyService copyService;

    Rent mapToRent(final RentDto rentDto) {
        Reader reader = readerService.getReaderById(rentDto.getReaderId());
        Copy copy = copyService.getCopyById(rentDto.getCopyId());

        return new Rent(
                rentDto.getId(),
                rentDto.getRentDate(),
                rentDto.getReturnDate(),
                reader,
                copy);
    }

    RentDto mapToRentDto(final Rent rent) {
        return new RentDto(
                rent.getId(),
                rent.getReader().getId(),
                rent.getCopy().getId(),
                rent.getRentDate(),
                rent.getReturnDate());
    }
}