import React from "react";
import Email from "../img/email.png";
function MembershipStep() {
  return (
    <div className="membership">
      <h2>Register Steps</h2>
      <div className="step_by_step">
        <div className="step_by_step_each">
          <img src={Email} alt="" />
          <h4>1.Step</h4>
          <p>Register online</p>
        </div>
        <div className="step_by_step_each">
          <img src={Email} alt="" />
          <div>
            <h4>2.Step</h4>
            <p>Sign the incoming contract</p>
          </div>
        </div>
        <div className="step_by_step_each">
          <img src={Email} alt="" />
          <h4>1.Step</h4>
          <p>Register online</p>
        </div>
        <div className="step_by_step_each">
          <img src={Email} alt="" />
          <h4>1.Step</h4>
          <p>Register online</p>
        </div>
      </div>
    </div>
  );
}

export default MembershipStep;
