import React from "react";
import axios from "axios";
import Swal from "sweetalert2";
import { useState } from "react";

function Login() {
  const [restaurant, setRestaurant] = useState({
    mail: "",
    password: "",
  });

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:8081/api/v1/restaurant-auth/login",
        restaurant
      );
      if (response) {
        alert(response.data.token);
      }
    } catch (error) {
      console.log(error.response.data.message);
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: error.response.data.message,
      });
    }
  };

  return (
    <div>
      <div class="login-page">
        <div class="form">
          <form class="login-form" onSubmit={handleSubmit}>
            <input
              type="text"
              placeholder="username"
              onChange={(e) =>
                setRestaurant({
                  ...restaurant,
                  mail: e.target.value,
                })
              }
            />
            <input
              type="password"
              placeholder="password"
              onChange={(e) =>
                setRestaurant({
                  ...restaurant,
                  password: e.target.value,
                })
              }
            />
            <button type="submit">login</button>
            <p class="message">
              Not registered? <a href="#">Create an account</a>
            </p>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Login;
