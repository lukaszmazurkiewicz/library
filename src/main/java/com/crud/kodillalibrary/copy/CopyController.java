package com.crud.kodillalibrary.copy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/library/copies")
public class CopyController {
    private final CopyMapper copyMapper;
    private final CopyService copyService;

    @PostMapping
    Long addCopy(@RequestBody CopyDto copyDto) {
        log.info("Add copy called. CopyDto [{}]", copyDto);

        Copy copy = copyService.addCopy(copyMapper.mapToCopy(copyDto));
        return copy.getId();
    }

    @PatchMapping("/{status}/{id}")
    CopyDto changeStatus(@PathVariable Status status, @PathVariable long id) {
        log.info("Change status of copy.");

        return copyMapper.mapToCopyDto(copyService.changeStatus(status, id));
    }

    @GetMapping("/bookId/{bookId}")
    public Long howManyBooksAvailable(@PathVariable long bookId) {
        log.info("How many books of given BookId {}", bookId);

        return copyService.copiesAvailableToRent(bookId);
    }
}
