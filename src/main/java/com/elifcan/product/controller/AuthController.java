package com.elifcan.product.controller;

import com.elifcan.product.dto.request.DoRegisterRequestDto;
import com.elifcan.product.dto.response.BaseResponse;
import com.elifcan.product.entity.Auth;
import com.elifcan.product.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.elifcan.product.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {
    private final AuthService authService;

    @PostMapping(DO_REGISTER)
    public ResponseEntity<BaseResponse<Auth>> doRegister(@RequestBody DoRegisterRequestDto dto){
        Auth auth = authService.doRegister(dto);
        return ResponseEntity.ok(BaseResponse.<Auth>builder()
                .code(1101)
                .isSuccess(true)
                .message("User is registered successfully.")
                .data(auth)
                .build());
    }
}
