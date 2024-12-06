package com.learn.jasypt.service.impl;

import com.learn.jasypt.dto.DecodeRequestDto;
import com.learn.jasypt.dto.EncodeRequestDto;
import com.learn.jasypt.dto.Pair;
import com.learn.jasypt.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final PBEStringEncryptor stringEncryptor;

    @Override
    public Map<String, String> encode(EncodeRequestDto dto) {
        return new TreeMap<>(dto.getData().stream()
                .map(value -> new Pair<>(value, stringEncryptor.encrypt(value)))
                .collect(Collectors.toMap(
                        Pair::getKey,
                        Pair::getValue)));
    }

    @Override
    public Map<String, String> decode(DecodeRequestDto dto) {
        Map<String, String> decodedData = dto.getData().stream()
                .map(value -> new Pair<>(value, stringEncryptor.decrypt(value)))
                .collect(Collectors.toMap(
                        Pair::getKey,
                        Pair::getValue));

        return decodedData.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new)
                );
    }
}
