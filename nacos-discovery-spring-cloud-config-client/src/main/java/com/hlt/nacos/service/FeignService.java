package com.qiao.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 */
@FeignClient("nacos-producer")
@Service
public interface FeignService {
    @GetMapping("/echo/config")
    String getNacosProducer();
}
