package com.springboot.model;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetaData {

    private HttpStatus status;
    private  String message;
    private String next;
}
