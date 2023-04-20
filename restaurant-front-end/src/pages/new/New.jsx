import React from "react";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import "./new.scss";
import DriveFolderUploadOutlinedIcon from "@mui/icons-material/DriveFolderUploadOutlined";
import { useEffect, useState } from "react";
import Products from "../../service/Products";
import Category from "../../../src/category";
function New() {
  const [file, setFile] = useState("");
  const [selected, setSelected] = useState([]);
  const token =
    "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJNYW0iLCJpZCI6MSwiZXhwIjoxNjgxOTA5MDY0LCJpYXQiOjE2ODE5MDM2NjR9.puk9VcGEQYFl3YpLNlbGiZV8HWJzimg4Da2obNVTMNPvTZf2zDJQEUyVNQPwgb-VsJTZAetKcdC_m8FmOdthng";

  let [category, setCategory] = useState({
    category: [],
  });

  useEffect(() => {
    Products.getAllCategories().then(
      (response) => {
        setCategory(() => ({
          category: response.data,
        }));
      },
      () => {}
    );
  }, []);

  console.log(category.category);

  let [api, setApi] = useState({
    sizeOption: [],
  });

  useEffect(() => {
    Products.getAllSizeOption(token).then(
      (response) => {
        console.log(response.data);
        setApi(() => ({
          sizeOption: response.data,
        }));
      },
      () => {}
    );
  }, []);

  // CHECKBOX SEÇİLEN ELEMENTI ARRAYE ATMAK İÇİN
  const handleChange = (e, index) => {
    console.log(e.target.value);
    const activeData = document.getElementById(index).checked;
    console.log(activeData, "activeData");
    if (activeData == true) {
      setSelected((oldData) => [...oldData, e.target.value]);
    } else {
      setSelected(selected.filter((values) => values !== e.target.value));
    }
  };
  const loadOptions = (searchValue, callBack) => {
    setTimeout(() => {
      const filterOptions = api.sizeOption.filter((api) =>
        api.label.toLowerCase().includes(searchValue.toLowerCase())
      );

      console.log("loadOptions", searchValue, filterOptions);
      callBack(filterOptions);
    }, 1000);
  };
  console.log(selected);
  return (
    <div className="new">
      <Sidebar />
      <div className="newContainer">
        <Navbar />
        <div className="top">
          <h1>Add new Product</h1>
        </div>
        <div className="bottom">
          <div className="left">
            <img
              src={
                file
                  ? URL.createObjectURL(file)
                  : "https://icon-library.com/images/no-image-icon/no-image-icon-0.jpg"
              }
              alt="no-image"
            />
          </div>
          <div className="right">
            <form>
              <div className="product-info">
                <div className="product-info-left-side">
                  <h1>Product Info</h1>
                  <div className="formInput">
                    <label htmlFor="file">
                      <DriveFolderUploadOutlinedIcon className="icon" />
                    </label>
                    <input
                      type="file"
                      id="file"
                      style={{ display: "none" }}
                      onChange={(e) => setFile(e.target.files[0])}
                    />
                  </div>
                  <div className="formInput">
                    <input type="text" placeholder="Product Name" />
                  </div>
                  <div className="formInput">
                    <input type="number" placeholder="Price" />
                  </div>
                  <div className="formInput">
                    <textarea
                      cols="40"
                      rows="3"
                      placeholder="Ingreditions"
                    ></textarea>
                  </div>
                </div>
                <div className="product-info-right-side">
                  <div className="selectCategory">
                    <div>
                      <h2>Category:</h2>
                    </div>
                    <div className="categoryList">
                      {category.category.map((deneme, i) => (
                        <div key={i}>
                          <input
                            id={i}
                            type="checkbox"
                            value={deneme.categoryName}
                            onChange={(e) => handleChange(e, i)}
                          />{" "}
                          <span>{deneme.categoryName}</span>
                        </div>
                      ))}
                    </div>
                  </div>
                  <div className="sizeOption">
                    <div>
                      <h2>Size Option:</h2>
                    </div>
                    <div className="sizeOptionList">
                      {api.sizeOption.map((deneme, i) => (
                        <div key={i}>
                          <input
                            id={i}
                            type="checkbox"
                            value={deneme.label}
                            onChange={(e) => handleChange(e, i)}
                          />{" "}
                          <span>{deneme.label}</span>
                        </div>
                      ))}
                    </div>
                  </div>
                  <button type="submit">PRODUCT ADD</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default New;
