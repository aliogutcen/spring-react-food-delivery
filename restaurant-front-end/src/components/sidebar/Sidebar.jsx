import React from "react";
import "./sidebar.scss";
import DashboardIcon from "@mui/icons-material/Dashboard";
import DeliveryDiningOutlinedIcon from "@mui/icons-material/DeliveryDiningOutlined";
import Inventory2Icon from "@mui/icons-material/Inventory2";
import CreditCardIcon from "@mui/icons-material/CreditCard";
import CommentsDisabledIcon from "@mui/icons-material/CommentsDisabled";
import NotificationsIcon from "@mui/icons-material/Notifications";
import SettingsIcon from "@mui/icons-material/Settings";
import Person2Icon from "@mui/icons-material/Person2";
import LogoutIcon from "@mui/icons-material/Logout";
const Sidebar = () => {
  return (
    <div className="sidebar">
      <div className="top">
        <span className="logo">Delivo Restaurant </span>{" "}
      </div>
      <hr />
      <div className="center">
        <ul>
          <p className="title">MAIN</p>
          <li>
            <DashboardIcon className="icons" />
            <span>Dashboard</span>
          </li>
          <p className="title">LIST</p>
          <li>
            <Inventory2Icon className="icons" />
            <span>Products</span>
          </li>
          <li>
            <CreditCardIcon className="icons" />
            <span>Orders</span>
          </li>
          <li>
            <DeliveryDiningOutlinedIcon className="icons" />
            <span>Delivery</span>
          </li>
          <li>
            <CommentsDisabledIcon className="icons" />
            <span>Comments</span>
          </li>
          <p className="title">USEFUL</p>
          <li>
            <NotificationsIcon className="icons" />
            <span>Notifications</span>
          </li>
          <li>
            <SettingsIcon className="icons" />
            <span>Settings</span>
          </li>
          <p className="title">RESTAURANT</p>
          <li>
            <Person2Icon className="icons" />
            <span>Profile</span>
          </li>
          <li>
            <LogoutIcon className="icons" />
            <span>Logout</span>
          </li>
        </ul>
      </div>

      <div className="bottom">
        <div className="colorOption"></div>
        <div className="colorOption"></div>
      </div>
    </div>
  );
};

export default Sidebar;
