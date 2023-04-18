import axios from "axios";

const GET_ALL_PRODUCTS = "http://localhost:8084/product/getall/";

class Products {
  getAllProducts(token) {
    return axios.get(GET_ALL_PRODUCTS + token);
  }
}

export default new Products();
