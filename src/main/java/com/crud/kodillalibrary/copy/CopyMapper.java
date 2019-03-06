package com.crud.kodillalibrary.copy;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class CopyMapper {
    Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getId(),
                copyDto.getBook(),
                copyDto.getStatus());
    }

    CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getBook(),
                copy.getStatus());
    }

    List<CopyDto> mapToListCopyDto(final List<Copy> copies) {
        return copies.stream()
                .map(c -> mapToCopyDto(c))
                .collect(Collectors.toList());
    }
}
