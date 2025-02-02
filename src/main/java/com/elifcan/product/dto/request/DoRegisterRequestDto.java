package com.elifcan.product.dto.request;

public record DoRegisterRequestDto(
        String userName,
        String password,
        String rePassword) {
}
