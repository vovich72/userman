package com.github.bvb7.userman.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(description = "Error object")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@NoArgsConstructor
public class ApiError {

    @Schema(description = "Time stamp error")
    private LocalDateTime timestamp = LocalDateTime.now();

    @Schema(description = "Http ststus")
    private int status;

    @Schema(description = "Text error")
    private String error;

    @Schema(description = "Error Exception")
    private String exception;

    @Schema(description = "Error message")
    private String message;

    @Schema(description = "Path where have exception")
    private String path;


    public ApiError(HttpStatus httpStatus, String message) {
        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
        this.message = message;
    }
}
