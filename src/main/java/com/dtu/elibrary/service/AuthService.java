package com.dtu.elibrary.service;

import com.dtu.elibrary.payload.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
}
