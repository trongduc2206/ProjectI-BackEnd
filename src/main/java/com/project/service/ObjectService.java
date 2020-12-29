package com.project.service;

import com.project.controller.response.ObjectLongLatResponse;
import com.project.controller.response.ObjectResponseDto;

public interface ObjectService {
    ObjectResponseDto getNearestObjectByName(String name, Double lat, Double lng);
}
