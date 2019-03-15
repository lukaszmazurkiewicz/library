package com.crud.kodillalibrary.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/rents")
class RentController {
    private final RentMapper rentMapper;
    private final RentService rentService;

    @Autowired
    public RentController(RentMapper rentMapper, RentService rentService) {
        this.rentMapper = rentMapper;
        this.rentService = rentService;
    }

    @PostMapping
    Long rentBook(@RequestBody RentDto rentDto) {
        Rent rent = rentService.addRent(rentMapper.mapToRent(rentDto));
        return rent.getId();
    }

    @PatchMapping("{rentId}")
    RentDto returnBook(@PathVariable long rentId) {
        return rentMapper.mapToRentDto(rentService.returnBook(rentId));
    }
}
