import React from "react";
import Logo from "../../img/logo.png";
import "react-phone-number-input/style.css";
import PhoneInput from "react-phone-number-input";
import axios from "axios";
import { useState } from "react";
import { Link, useNavigate, useNavigation } from "react-router-dom";
import Swal from "sweetalert2";
import "./register.scss";
import {
  CountryDropdown,
  RegionDropdown,
  CountryRegionData,
} from "react-country-region-selector";
import { isValidPhoneNumber } from "react-phone-number-input";
import UserService from "../../service/UserService";

function Register() {
  const navigate = useNavigate();

  const [restaurant, setRestaurant] = useState({
    restaurantName: "",
    productsNumber: "",
    country: "",
    city: "",
    managerName: "",
    managerSurname: "",
    mail: "",
    phone: "",
    tcNo: "",
    productsNumber: "",
  });

  const [phone, setPhone] = useState("");
  const [country, setCountry] = useState("");
  const [region, setRegion] = useState("");

  const [formErrors, setFormErrors] = useState({});

  const handleSubmit = async (event) => {
    event.preventDefault();
    const errors = validateForm();
    if (Object.keys(errors).length === 0) {
      UserService.addUser(restaurant).then(
        () => {
          alert("the user has been added succesfully!");
        },
        () => {
          alert("the user has been added fa");
        }
      );
    } else {
      setFormErrors(errors);
    }
  };

  const validateForm = () => {
    let errors = {};
    if (!restaurant.restaurantName.trim()) {
      errors.restaurantName = "Restaurant name is required";
    }
    if (!restaurant.productsNumber.trim()) {
      errors.productsNumber = "Number of products is required";
    } else if (isNaN(restaurant.productsNumber)) {
      errors.productsNumber = "Number of products should be a number";
    } else if (parseInt(restaurant.productsNumber) < 0) {
      errors.productsNumber = "Number of products should be a positive number";
    }
    if (!restaurant.managerName.trim()) {
      errors.managerName = "Manager first name is required";
    }
    if (!restaurant.managerSurname.trim()) {
      errors.managerSurname = "Manager last name is required";
    }
    if (!restaurant.mail.trim()) {
      errors.mail = "E-mail is required";
    } else if (!/\S+@\S+\.\S+/.test(restaurant.mail)) {
      errors.mail = "Invalid e-mail address";
    }
    if (restaurant.tcNo && isNaN(restaurant.tcNo)) {
      errors.tcNo = "T.C. No should be a number";
    } else if (restaurant.tcNo && restaurant.tcNo.length !== 11) {
      errors.tcNo = "T.C. No should be 11 digits";
    }
    if (!phone) {
      errors.phone = "Phone number is required";
    }
    if (!restaurant.country) {
      errors.country = "Country is required";
    }
    if (!restaurant.city) {
      errors.city = "City/Region is required";
    }
    return errors;
  };

  return (
    <div className="register">
      <div className="left-side">
        <div className="left-side_title">
          <h1>DELIVO</h1>
        </div>
      </div>
      <div className="right-side">
        <form className="right-side" onSubmit={handleSubmit}>
          <div>
            <h6>Delivo-Apply Now</h6>
            <p>
              Become one of FoodCall's restaurant partners, grow your business
              with less cost and increase customer satisfaction.
            </p>
          </div>
          <div className="restaurant-info">
            <div>
              <input
                type="text"
                placeholder="Restaurant Name"
                onChange={(e) =>
                  setRestaurant({
                    ...restaurant,
                    restaurantName: e.target.value,
                  })
                }
              />
              {formErrors.restaurantName && (
                <p className="error">{formErrors.restaurantName}</p>
              )}
            </div>
            <div>
              <CountryDropdown
                value={country}
                onChange={(val) => setCountry(val)}
              />
              {formErrors.country && (
                <p className="error">{formErrors.country}</p>
              )}
            </div>
          </div>
          <div className="restaurant-info">
            <div>
              <RegionDropdown
                className="region"
                country={country}
                value={region}
                onChange={(val) => setRegion(val)}
              />
              {formErrors.country && (
                <p className="error">{formErrors.country}</p>
              )}
            </div>
            <div>
              <input
                type="number"
                placeholder="How many products do you have "
                onChange={(e) =>
                  setRestaurant({
                    ...restaurant,
                    productsNumber: e.target.value,
                  })
                }
              />
              {formErrors.productsNumber && (
                <p className="error">{formErrors.productsNumber}</p>
              )}
            </div>
          </div>
          <div>
            <h6>Company Official Information</h6>
            <p>
              Company authorised person information belongs to the person
              information in the signature circular. You must make sure that the
              information is filled in correctly and completely.
            </p>
          </div>

          <div className="restaurant-info">
            <div>
              <input
                type="text"
                placeholder="Firstname  "
                onChange={(e) =>
                  setRestaurant({ ...restaurant, managerName: e.target.value })
                }
              />
              {formErrors.managerName && (
                <p className="error">{formErrors.managerName}</p>
              )}
            </div>
            <div>
              <input
                type="text"
                placeholder="Surname"
                onChange={(e) =>
                  setRestaurant({
                    ...restaurant,
                    managerSurname: e.target.value,
                  })
                }
              />
              {formErrors.managerSurname && (
                <p className="error">{formErrors.managerSurname}</p>
              )}
            </div>
          </div>
          <div className="restaurant-info">
            <div>
              <input
                type="email"
                placeholder="E-mail address  "
                onChange={(e) =>
                  setRestaurant({ ...restaurant, mail: e.target.value })
                }
              />
              {formErrors.mail && <p className="error">{formErrors.mail}</p>}
            </div>
            <div>
              <input
                type="text"
                placeholder="T.C No"
                onChange={(e) =>
                  setRestaurant({ ...restaurant, tcNo: e.target.value })
                }
              />
              {formErrors.tcNo && <p className="error">{formErrors.tcNo}</p>}
            </div>
          </div>

          <div className="restaurant-info">
            <div>
              <PhoneInput
                className="phone"
                placeholder="Enter phone number"
                onChange={(e) => setPhone(e)}
              />
              {formErrors.phone && <p className="error">{formErrors.phone}</p>}
            </div>
          </div>
          <button
            id="button"
            type="submit"
            onClick={(e) => {
              setRestaurant({
                ...restaurant,
                phone: phone,
                country: country,
                city: region,
              });
            }}
          >
            Complate
          </button>
          <Link id="login_button" type="submit" to="/login">
            Back to Login
          </Link>
        </form>
      </div>
    </div>
  );
}

export default Register;
