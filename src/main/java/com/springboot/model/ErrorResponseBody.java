package com.springboot.model;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ErrorResponseBody {

        private String timeStamp;

        private int status;

        private HttpStatusCode error;

        private String message;

        private  String path;

}
