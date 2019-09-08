package com.orgon.config;

public class Messages {

    public static String APPLICATION_STARTED_MESSAGE =
            "Application is running on http://" + Config.HOSTNAME + ":" + Config.PORT + "api/chemtrails";

    public static final String GET_ORGON_LIST_MESSAGE = "Gettling all orgons...";
    public static final String GET_ORGON_BY_ID_MESSAGE = "Getting orgon with id: ";
    public static final String POST_NEW_ORGON_MESSAGE = "Posted new item to orgon repository: \n";
    public static final String REMOVE_ORGON_BY_ID_MESSAGE = "Removed orgon with id: ";
    public static final String UPDATE_ORGON_BY_ID_MESSAGE = "Updated orgon with id: ";
}
