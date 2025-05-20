package com.example.BigganGlopo.auth.service;


import com.example.BigganGlopo.auth.dto.request.UserRequestDTO;
import com.example.BigganGlopo.auth.dto.request.UserRoleRequestDTO;
import com.example.BigganGlopo.auth.dto.response.CustomUserResponseDTO;
import com.example.BigganGlopo.auth.model.User;

public interface UserService {

    public String create(UserRequestDTO requestDto);
    public CustomUserResponseDTO readOne(Long id );
    public User setUserRoles(UserRoleRequestDTO requestDTO );
    public void updateUser(Long id, UserRequestDTO userRequestDTO);
    public CustomUserResponseDTO searchByUsername(String username);
    public String validateOtp(String email, String otp);
}