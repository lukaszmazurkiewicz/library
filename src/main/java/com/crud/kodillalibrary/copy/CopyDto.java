package com.crud.kodillalibrary.copy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
class CopyDto {
    private long id;
    private long bookId;
    private String status;
}
