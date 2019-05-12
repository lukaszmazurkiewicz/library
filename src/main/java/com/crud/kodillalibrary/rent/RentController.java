package com.crud.kodillalibrary.rent;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/library/rents")
class RentController {
    private final RentMapper rentMapper;
    private final RentService rentService;

    @PostMapping
    Long rentBook(@RequestBody RentDto rentDto) {
        log.info("Add rent called. RentDto [{}]", rentDto);

        Rent rent = rentService.addRent(rentMapper.mapToRent(rentDto));
        return rent.getId();
    }

    @PatchMapping("/{rentId}")
    RentDto returnBook(@PathVariable long rentId) {
        log.info("Return of the book!");

        return rentMapper.mapToRentDto(rentService.returnBook(rentId));
    }
}
