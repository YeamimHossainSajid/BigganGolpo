package com.example.BigganGlopo.auth.service;

import com.example.BigganGlopo.auth.dto.response.CustomRoleResponseDTO;

public interface RoleService {

    public CustomRoleResponseDTO readOne(Long id );
    public String delete( Long id );

}
