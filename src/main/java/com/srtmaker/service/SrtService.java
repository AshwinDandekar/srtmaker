package com.srtmaker.service;

import com.srtmaker.request.SrtRequest;
import com.srtmaker.response.SrtResponse;
import com.srtmaker.utils.SrtUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class SrtService {

    @Autowired
    private SrtUtils srtUtils;

    public SrtResponse convertToSrt(SrtRequest srtRequest) {
        String subtitleText = srtUtils.getSrtText(srtRequest.getTextValue(), srtRequest.getWordsPerMinute());
        return new SrtResponse();
    }
}
