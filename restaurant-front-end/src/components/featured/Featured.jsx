import "./featured.scss";
import MoreVertOutlinedIcon from "@mui/icons-material/MoreVertOutlined";
import { CircularProgressbar } from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";
import { useEffect, useState } from "react";
import UserService from "../../service/UserService";
const Featured = () => {
  let [state, setState] = useState({
    users: [],
  });
  const token = useEffect(() => {
    UserService.getAllUsers().then(
      (response) => {
        setState(() => ({
          users: response.data,
        }));
        console.log(JSON.stringify(state.users));
      },
      () => {}
    );
  }, []);

  return (
    <div className="featured">
      <div className="top">
        <h1 className="title">Total Revenue</h1>
        <MoreVertOutlinedIcon fontSize="min" />
      </div>
      <div className="bottom">
        <div className="featuredChart">
          <CircularProgressbar
            value={state.users.length}
            text={"70%"}
            strokeWidth={5}
            maxValue={100}
          />
        </div>
        <p className=" title">Total sales made today</p>
        <p className=" amount">{state.users.length}</p>
        <p className=" desc">
          Payments from the last order have not been added
        </p>
      </div>
    </div>
  );
};

export default Featured;
