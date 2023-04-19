import axios from "axios";

const GET_ALL_PRODUCTS = "http://localhost:8084/product/getall/";

const GET_ALL_SIZE_OPTION =
  "http://localhost:8084/v1/api/size-option/getallsize/";

class Products {
  getAllProducts(token) {
    return axios.get(GET_ALL_PRODUCTS + token);
  }
  getAllSizeOption(token) {
    return axios.get(GET_ALL_SIZE_OPTION + token);
  }
}

export default new Products();
