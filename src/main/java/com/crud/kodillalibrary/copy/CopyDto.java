package com.crud.kodillalibrary.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class CopyDto {
    private long id;
    private long bookId;
    private Status status;
}
