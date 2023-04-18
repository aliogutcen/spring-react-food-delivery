import "./table.scss";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useEffect, useState } from "react";
import UserService from "../../service/UserService";

const List = () => {
  let [state, setState] = useState({
    users: [],
  });

  useEffect(() => {
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
    <TableContainer component={Paper} className="table">
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell className="tableCells">Tracking ID</TableCell>
            <TableCell className="tableCells">Customer</TableCell>
            <TableCell className="tableCells">Amount</TableCell>
            <TableCell className="tableCells">Payment Method</TableCell>
            <TableCell className="tableCells">Status</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {state.users.map((users) => (
            <TableRow key={users.id}>
              <TableCell className="tableCell">{users.mail}</TableCell>
              <TableCell className="tableCell">{users.esupportType}</TableCell>
              <TableCell className="tableCell">{users.localDate}</TableCell>
              <TableCell className="tableCell">{users.mail}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default List;
