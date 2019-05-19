package com.crud.kodillalibrary.reader;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/readers")
@CrossOrigin(origins = "*")
class ReaderController {
    private final ReaderMapper readerMapper;
    private final ReaderService readerService;

    @PostMapping
    Long addReader(@RequestBody ReaderDto readerDto) {
        log.info("Add reader called. ReaderDto [{}]", readerDto);

        Reader reader = readerService.addReader(readerMapper.mapToReader(readerDto));
        return reader.getId();
    }
}
