package com.learn.jasypt.rest;


import com.learn.jasypt.dto.DecodeRequestDto;
import com.learn.jasypt.dto.EncodeRequestDto;
import com.learn.jasypt.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SecurityController {

    private final SecurityService securityService;

    @PostMapping(value = "/encode")
    public Map<String, String> encode(@RequestBody EncodeRequestDto dto) {
        return securityService.encode(dto);
    }

    @PostMapping(value = "/decode")
    public Map<String, String> decode(@RequestBody DecodeRequestDto dto) {
        return securityService.decode(dto);
    }
}
