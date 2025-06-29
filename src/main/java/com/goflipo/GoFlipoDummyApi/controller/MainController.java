package com.goflipo.GoFlipoDummyApi.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.goflipo.GoFlipoDummyApi.dao.AuthCodeResponse;
import com.goflipo.GoFlipoDummyApi.dao.GoFlipoRequestPayload;
import com.goflipo.GoFlipoDummyApi.dao.GoFlipoResponse;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

@RestController
public class MainController {



    @PostMapping("/api/main/scrubbing-logs")
    public Mono<GoFlipoResponse> generate(@RequestBody Mono<JsonNode> request) {

        String uuid = UUID.randomUUID().toString();
        AuthCodeResponse authData = new AuthCodeResponse(uuid);

        GoFlipoResponse<AuthCodeResponse> response =
                new GoFlipoResponse<>(true, "Scrubbing loged successfully", authData);

        return Mono.just(response);
    }

   //https://smartping-backend.goflipo.com/api/main/scrubbing-logs?authcode=febb5e83-4d86-499d
   //-a60b-ca0b06045974

   @GetMapping("/api/main/scrubbing-logs")
    public Mono<GoFlipoResponse> pingGenerate(@RequestParam(name = "authcode") String request)
    {

        AuthCodeResponse authData = new AuthCodeResponse(request);
        GoFlipoResponse<AuthCodeResponse> response =
                new GoFlipoResponse<>(true, "Scrubbing loged successfully", authData);

        return Mono.just(response);
    }

}
