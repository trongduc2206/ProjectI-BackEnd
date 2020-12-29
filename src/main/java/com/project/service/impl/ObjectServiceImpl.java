package com.project.service.impl;

import com.project.controller.response.ObjectResponseDto;
import com.project.domain.ResponseStatus;
import com.project.service.ObjectService;
import com.project.constant.MessageConstant;
import com.project.controller.response.ObjectLongLatResponse;
import com.project.exception.NotFoundException;
import com.project.repository.ObjectRepository;
import com.project.repository.entity.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.*;

@Service
public class ObjectServiceImpl implements ObjectService {
    public ObjectRepository objectRepository;

    @Autowired
    public ObjectServiceImpl(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    @Override
    public ObjectResponseDto getNearestObjectByName(String name, Double lat, Double lng) {
        ObjectResponseDto objectResponseDto = new ObjectResponseDto();
        Optional<List<Object>> objects = objectRepository.findByNameContaining(name);
//        ObjectLongLatResponse objectLongLatResponse= new ObjectLongLatResponse();
        List<ObjectLongLatResponse> objectLongLatResponses = new ArrayList<>();

        if (objects.isPresent()) {
            List<Object> sortedObjects = sortByDistance(objects.get(), lat, lng);
            int tmp=0;
            for (Object object : sortedObjects) {
                tmp=tmp+1;
                ObjectLongLatResponse objectLongLatResponse = new ObjectLongLatResponse();
                objectLongLatResponse.setName(object.getName());
                objectLongLatResponse.setLatitude(object.getLatitude());
                objectLongLatResponse.setLongitude(object.getLongitude());
                objectLongLatResponses.add(objectLongLatResponse);
                if(tmp>=5) break;
            }
            objectResponseDto.setStatus(new ResponseStatus("000", "success"));
            objectResponseDto.setData(objectLongLatResponses);

        }
      else objectResponseDto.setStatus(new ResponseStatus("001", "Not found object"));
       return objectResponseDto;
    }

    public Double calDistance(Object a, Double secondObjLat, Double secondObjLng){
        return 6378* Math.acos(Math.sin(a.getLatitude())*Math.sin(secondObjLat))
                + Math.cos(a.getLatitude())*Math.cos(secondObjLat)*Math.cos(a.getLongitude()-secondObjLng);
    }

    public List<Object> sortByDistance(List<Object> objects,Double secondObjLat, Double secondObjLng){
        Map<Object, Double> sortedList = new HashMap<>();
        for(Object object : objects){
            Double distance = calDistance(object,secondObjLat, secondObjLng);
            sortedList.put(object, distance);
        }
        Set<Map.Entry<Object, Double>> entries = sortedList.entrySet();
        Comparator<Map.Entry<Object, Double>> comparator = new Comparator<Map.Entry<Object, Double>>() {
            @Override
            public int compare(Map.Entry<Object, Double> o1, Map.Entry<Object, Double> o2) {
                Double distance1= o1.getValue();
                Double distance2= o2.getValue();
                return distance1>distance2?1:-1;
            }
        };
        List<Map.Entry<Object, Double>> entryList = new ArrayList<>(entries);
        Collections.sort(entryList, comparator);
        List<Object> objectList = new ArrayList<>();
        for(Map.Entry<Object, Double> entry: entryList){
            objectList.add(entry.getKey());
        }
        return objectList;
    }
}
