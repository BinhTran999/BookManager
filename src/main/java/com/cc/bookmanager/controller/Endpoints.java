package com.cc.bookmanager.controller;

public interface Endpoints {
    String LOGIN_URL = "/login";
    String LOGOUT_URL = "/logout";
    String PATH_VARIABLE_ID = "/{uuid}";
    String PATH_VARIABLE_PARENT_ID = "/{parentid}";
    String PATH_VARIABLE_PARENT_CODE = "/{parentcode}";
    String PATH_VARIABLE_CODE = "/{code}/code";
    String PATH_FIND_PARENT_ID = "/find-by-parent-id";
    String PATH_FIND_PARENT_CODE = "/find-by-parent-code";
    String IMPORT_FILE_DATA = "/import-file";
    String DOWNLOAD_FILE = "/download-file";    // Request link
    String GET_ALL_PATH = "/get-all";
    String CREATE_PATH = "/";
    String UPDATE_PATH = PATH_VARIABLE_ID;
    String DELETE_PATH = PATH_VARIABLE_ID;
    String DETAIL_PATH = PATH_VARIABLE_ID;
    String SEARCH_PATH = "/";
    String PREFIX = "/bookstory/";

    String LOGIN = "login";
    String LIST_CHILDREN = PATH_VARIABLE_PARENT_ID + GET_ALL_PATH;
}

