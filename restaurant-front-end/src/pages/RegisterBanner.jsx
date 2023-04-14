import React from "react";
import Banner from "../img/bubble-gum-man-and-woman-high-fiving-each-other.png";
function RegisterBanner() {
  return (
    <div className="banner-register">
      <img src={Banner} alt="" />
      <div className="banner-register_text">
        <h4>Advantages of being our business partner</h4>
      </div>
    </div>
  );
}

export default RegisterBanner;
