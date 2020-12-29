package com.project.controller;

import com.project.controller.response.ObjectResponseDto;
import com.project.service.ObjectService;
import com.project.controller.response.ObjectLongLatResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@Slf4j
@RestController
@RequestMapping("/internal/object/v1/objects")
public class ObjectController extends BaseController{
    private ObjectService objectService;

    public ObjectController(ObjectService objectService){
        this.objectService= objectService;
    }
    @GetMapping("/{name}/{lat}/{lng}")
    public ObjectResponseDto getObjectByName(@PathVariable String name,
                                             @PathVariable Double lat,
                                             @PathVariable Double lng
                                             ){
        ObjectResponseDto objectResponseDto=objectService.getNearestObjectByName(name, lat, lng);
        return objectResponseDto;
    }
}
