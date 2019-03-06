package com.crud.kodillalibrary.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library/copies")
public class CopyController {
    private final CopyMapper copyMapper;
    private final CopyService copyService;

    @Autowired
    public CopyController(CopyMapper copyMapper, CopyService copyService) {
        this.copyMapper = copyMapper;
        this.copyService = copyService;
    }

    @PostMapping
    void addCopy(@RequestBody CopyDto copyDto) {
        copyService.addCopy(copyMapper.mapToCopy(copyDto));
    }

    @PatchMapping("{id}")
    CopyDto changeStatus(@RequestBody CopyDto copyDto, @PathVariable long id) {
        return copyMapper.mapToCopyDto(copyService.changeStatus(copyDto, id));
    }

    @GetMapping
    public List<CopyDto> howManyBooksAvailable() {
        return copyMapper.mapToListCopyDto(copyService.copiesAvailableToRent());
    }
}
