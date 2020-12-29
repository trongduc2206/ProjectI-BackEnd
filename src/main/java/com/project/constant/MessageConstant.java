package com.project.constant;

/**
 * @author : Hoang Cuong
 * @since : 2019-09-07, Sat
 **/
public class MessageConstant {
    private MessageConstant() {
    	super();
    }

    public static final String SUCCESS = "000";
    public static final String SUCCESS_MESSAGE = "success";
    public static final String GENERAL_ERROR = "999";
    
    public static final String INVALID_REFRESH_TOKEN_OR_EXPIRED = "A-001";
    public static final String INVALID_TOKEN_OR_EXPIRED = "A-002";
    public static final String NOT_FOUND_USER = "A-003";
    public static final String INVALID_USER_DATA = "A-004";
    public static final String CATEGORY_NOT_FOUND ="category_not_found";
    public static final String PRODUCER_NOT_FOUND ="producer_not_found";

    public static final String INVALID_REQUEST_CREATE_ITEM = "E-ITEM-998";
    public static final String INVALID_REQUEST_UPDATE_ITEM = "E-ITEM-997";
    public static final String INVALID_REQUEST_SEARCH_ITEM = "E-ITEM-996";
    public static final String ITEM_NOT_FOUND = "E-ITEM-995";

    public static final String INVALID_REQUEST_CREATE_ITEM_PROPERTY = "E-ITEM-PROP-994";
    public static final String INVALID_REQUEST_UPDATE_ITEM_PROPERTY = "E-ITEM-PROP-993";
    public static final String INVALID_REQUEST_SEARCH_ITEM_PROPERTY = "E-ITEM-PROP-992";
    public static final String ITEM_PROPERTY_NOT_FOUND = "E-ITEM-PROP-991";

    public static final String INVALID_REQUEST_CREATE_PERIOD = "E-ITEM-PROP-990";
    public static final String INVALID_REQUEST_UPDATE_PERIOD = "E-ITEM-PROP-989";
    public static final String INVALID_REQUEST_SEARCH_PERIOD = "E-ITEM-PROP-988";
    public static final String PERIOD_NOT_FOUND = "E-ITEM-PROP-987";
}
