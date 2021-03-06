package com.me.core.constant;

public interface ApiPath {

  String BASE_PATH = "/me-core";
  String SYSTEM_PARAMETER = BASE_PATH + "/systemParameters";
  String ID = "/{id}";
  String USER = BASE_PATH + "/user";
  String MERCHANT = BASE_PATH + "/merchant";
  String AUTH = BASE_PATH + "/auth";
  String CART = BASE_PATH + "/cart";
  String SYNC = BASE_PATH + "/sync";
  String PRODUCT = BASE_PATH + "/product";
  String STORE = BASE_PATH + "/store";
  String APPEND_ACTIVE = "/active";
  String APPEND_REGISTER = "/register";
  String APPEND_VERIFICATION = "/verification";
  String APPEND_UPDATE = "/update";
  String APPEND_LOGIN = "/login";
  String APPEND_LOGOUT = "/logout";
  String APPEND_REFRESH = "/refresh";
  String APPEND_ALL = "/all";
}
