import React from "react";
import "./newarea.scss";
import { Link } from "react-router-dom";
const NewArea = () => {
  return (
    <div className="newarea">
      <Link
        to="/products/new"
        className="link"
        style={{ textDecoration: "none" }}
      >
        Add new product
      </Link>
      <Link className="link" style={{ textDecoration: "none" }}>
        Add new category
      </Link>
      <Link className="link" style={{ textDecoration: "none" }}>
        Add new size
      </Link>
    </div>
  );
};

export default NewArea;
