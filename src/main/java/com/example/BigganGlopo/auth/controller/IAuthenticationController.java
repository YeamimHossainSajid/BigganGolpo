package com.example.BigganGlopo.auth.controller;

import com.example.BigganGlopo.auth.dto.request.LoginRequestDTO;
import com.example.BigganGlopo.auth.dto.response.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationController {

    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO requestDTO );

}
