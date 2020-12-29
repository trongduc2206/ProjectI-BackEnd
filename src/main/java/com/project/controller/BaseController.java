package com.project.controller;


import com.project.constant.MessageConstant;
import com.project.domain.GeneralResponse;
import com.project.domain.ResponseStatus;

abstract class BaseController {

    GeneralResponse success() {
        GeneralResponse responseObject = new GeneralResponse();
        responseObject.setStatus(getResponseStatus(MessageConstant.SUCCESS));
        return responseObject;
    }

    <T extends GeneralResponse> T success(T responseObject) {
        responseObject.setStatus(getResponseStatus(MessageConstant.SUCCESS));
        return responseObject;
    }

    <T extends GeneralResponse> T error(T responseObject, String code) {
        responseObject.setStatus(getResponseStatus(code));

        return responseObject;
    }

    private ResponseStatus getResponseStatus(String code) {
//        return new ResponseStatus(code, MessageTranslator.getMessage(code));
        return new ResponseStatus(code, "message");
    }

}
