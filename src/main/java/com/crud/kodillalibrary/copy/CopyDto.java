package com.crud.kodillalibrary.copy;

import lombok.Value;

@Value
class CopyDto {
    private long id;
    private long bookId;
    private Status status;
}
