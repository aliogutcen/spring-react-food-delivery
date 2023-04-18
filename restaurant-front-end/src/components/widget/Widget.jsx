import React from "react";
import "./widget.scss";
import KeyboardArrowUpOutlinedIcon from "@mui/icons-material/KeyboardArrowUpOutlined";
import AccountBalanceOutlinedIcon from "@mui/icons-material/AccountBalanceOutlined";
import ShoppingCartOutlinedIcon from "@mui/icons-material/ShoppingCartOutlined";
import AttachMoneyOutlinedIcon from "@mui/icons-material/AttachMoneyOutlined";
import ProductionQuantityLimitsOutlinedIcon from "@mui/icons-material/ProductionQuantityLimitsOutlined";
import Products from "../../service/Products";
import { useEffect, useState } from "react";
const Widget = ({ type }) => {
  let data;

  let [state, setState] = useState({
    users: [],
  });
  const token =
    "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJNYW0iLCJpZCI6MSwiZXhwIjoxNjgxODI0OTk1LCJpYXQiOjE2ODE4MTk1OTV9.gS_KNJqLQRG_HQwygjJqX-gslRi-2R8HFME1NLKlOHXQgTbiMiiZMcUrVGZClnzN9cnHWIdLcJy-EnYkiv5Wdw";
  useEffect(() => {
    Products.getAllProducts(token).then(
      (response) => {
        setState(() => ({
          users: response.data,
        }));
        console.log(JSON.stringify(state.users));
      },
      () => {}
    );
  }, []);

  const amount = state.users.length;
  switch (type) {
    case "products":
      data = {
        title: "PRODUCTS",
        isMoney: false,
        link: "See all products",
        icon: (
          <ProductionQuantityLimitsOutlinedIcon
            className="icon"
            style={{
              backgroundColor: "rgba(220, 20, 60, 0.411)",
              color: "crimson",
            }}
          />
        ),
      };
      break;
    case "order":
      data = {
        title: "ORDERS",
        isMoney: false,
        link: "See all orders",
        icon: (
          <ShoppingCartOutlinedIcon
            className="icon"
            style={{
              backgroundColor: "rgba(218, 165, 32, 0.2)",
              color: "golden",
            }}
          />
        ),
      };
      break;
    case "earning":
      data = {
        title: "EARNING",
        isMoney: true,
        link: "See all earning",
        icon: (
          <AttachMoneyOutlinedIcon
            className="icon"
            style={{
              backgroundColor: "rgba(0, 128, 0, 0.253)",
              color: "green",
            }}
          />
        ),
      };
      break;
    case "balance":
      data = {
        title: "BALANCE",
        isMoney: false,
        link: "See all orders",
        icon: (
          <AccountBalanceOutlinedIcon
            className="icon"
            style={{
              backgroundColor: "rgba(128, 0, 128, 0.219)",
              color: "purple",
            }}
          />
        ),
      };
      break;
    default:
      break;
  }
  return (
    <div className="widget">
      <div className="left">
        <span className="title">{data.title}</span>
        <span className="counter">
          {data.isMoney && "$"}
          {amount}
        </span>
        <span className="link">{data.link}</span>
      </div>
      <div className="right">
        <div className="percentage">
          <KeyboardArrowUpOutlinedIcon />
          20%
        </div>
        {data.icon}
      </div>
    </div>
  );
};

export default Widget;
