import "./featured.scss";
import MoreVertOutlinedIcon from "@mui/icons-material/MoreVertOutlined";
import { CircularProgressbar } from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";
const Featured = () => {
  return (
    <div className="featured">
      <div className="top">
        <h1 className="title">Total Revenue</h1>
        <MoreVertOutlinedIcon fontSize="min" />
      </div>
      <div className="bottom">
        <div className="featuredChart">
          <CircularProgressbar value={70} text={"70%"} strokeWidth={5} />
        </div>
        <p className=" title">Total sales made today</p>
        <p className=" amount">$420</p>
        <p className=" desc">
          Payments from the last order have not been added
        </p>
      </div>
    </div>
  );
};

export default Featured;
