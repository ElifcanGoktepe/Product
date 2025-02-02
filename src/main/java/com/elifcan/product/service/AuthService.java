package com.elifcan.product.service;

import com.elifcan.product.dto.request.DoRegisterRequestDto;
import com.elifcan.product.entity.Auth;
import com.elifcan.product.repository.AuthRepository;
import com.elifcan.product.utility.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;

    public Auth doRegister(DoRegisterRequestDto dto) {
        Auth auth = Auth.builder()
                .userName(dto.userName())
                .password(dto.password())
                .roleType(RoleType.USER)
                .build();
        repository.save(auth);
        return auth;
    }
}
