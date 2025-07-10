package com.github.bvb7.userman.dto;

import com.github.bvb7.userman.enums.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "User object")
public record UserDto(

        @Schema(description = "User nick", example = "User6532")
        String nick,

        @Schema(description = "User first name", example = "John")
        String firstName,

        @Schema(description = "User last name. Full name - John User", example = "BigUser")
        String lastName,

        @Schema(description = "User age", example = "20")
        int age,

        @Schema(description = "User phone", example = "+123456789012")
        String phone,

        @Schema(description = "User email", example = "abc@example.dev")
        String email,

        @Schema(description = "User data registration/ create", example = "2025-07-10", accessMode = Schema.AccessMode.READ_ONLY)
        LocalDateTime registrationDate,

        @Schema(description = "User status", allowableValues = {"ACTIVE", "INACTIVE", "BANNED"})
        UserStatus status
) {
}
