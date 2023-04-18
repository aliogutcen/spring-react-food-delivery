import React from "react";
import axios from "axios";

const GET_ALL_USER_URL =
  "http://localhost:8082/api/v1/support/register-configration";
const SAVE_USER = "http://localhost:8080/api/v1/restaurant-register/save";
class UserService {
  getAllUsers() {
    return axios.get(GET_ALL_USER_URL);
  }

  addUser(user) {
    return axios.post(SAVE_USER, user);
  }
}

export default new UserService();
