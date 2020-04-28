package com.srtmaker.controller;

import com.srtmaker.request.SrtRequest;
import com.srtmaker.response.SrtResponse;
import com.srtmaker.service.SrtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/srtmaker")
public class SrtController {

    @Autowired
    private SrtService srtService;
    @PostMapping
    public SrtResponse convertToSrt(@RequestBody SrtRequest request){
        return srtService.convertToSrt(request);
    }

}
