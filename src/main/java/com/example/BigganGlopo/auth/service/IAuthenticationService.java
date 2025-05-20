package com.example.BigganGlopo.auth.service;


import com.example.BigganGlopo.auth.dto.request.LoginRequestDTO;
import com.example.BigganGlopo.auth.dto.response.LoginResponseDTO;

public interface IAuthenticationService {
    LoginResponseDTO login(LoginRequestDTO requestDTO );
}
