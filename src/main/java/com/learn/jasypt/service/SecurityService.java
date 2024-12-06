package com.learn.jasypt.service;

import com.learn.jasypt.dto.DecodeRequestDto;
import com.learn.jasypt.dto.EncodeRequestDto;

import java.util.Map;

public interface SecurityService {
    Map<String, String> encode(EncodeRequestDto dto);

    Map<String, String> decode(DecodeRequestDto dto);
}
