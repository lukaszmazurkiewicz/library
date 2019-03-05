package com.crud.kodillalibrary.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/readers")
class ReaderController {
    private final ReaderMapper readerMapper;
    private final ReaderService readerService;

    @Autowired
    public ReaderController(ReaderMapper readerMapper, ReaderService readerService) {
        this.readerMapper = readerMapper;
        this.readerService = readerService;
    }

    @PostMapping
    void addReader(@RequestBody ReaderDto readerDto) {
        readerService.addReader(readerMapper.mapToReader(readerDto));
    }
}
