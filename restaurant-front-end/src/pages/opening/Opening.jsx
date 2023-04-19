import React from "react";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import "./opening.scss";
import { useState } from "react";
const Opening = () => {
  const weekDay = [
    "MONDAY",
    "TUESDAY",
    "WEDNESDAY",
    "THURSDAY",
    "FRIDAY",
    "SATURDAY",
    "SUNDAY",
  ];
  const [selected, setSelected] = useState([]);
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
  console.log(weekDay);
  return (
    <div className="opening">
      <Sidebar />
      <div className="openinTime">
        <Navbar />
        <div className="time">
          <div className="days">
            <h2>Opening Days</h2>
            {weekDay.map((weekDay, i) => (
              <div className="weekDay" key={i}>
                <input
                  id={i}
                  type="checkbox"
                  value={weekDay}
                  onChange={(e) => handleChange(e, i)}
                />{" "}
                <span>{weekDay}</span>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Opening;
