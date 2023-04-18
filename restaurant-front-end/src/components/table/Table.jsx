import "./table.scss";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";

const List = () => {
  const rows = [
    {
      id: 1143155,
      customer: "Melihcan Öztürk",
      amount: 785,
      method: "Cash on Delivery",
      status: "Approved",
    },
    {
      id: 2235235,
      customer: "Buse Çankaya",
      amount: 900,
      method: "Online Payment",
      status: "Pending",
    },
    {
      id: 2342353,
      customer: "Furkan Turkmen",
      amount: 35,
      method: "Cash on Delivery",
      status: "Pending",
    },
    {
      id: 2357741,
      customer: "Mert Namsal",
      amount: 920,
      method: "Online",
      status: "Approved",
    },
    {
      id: 2342355,
      customer: "Ali Öğütçen",
      amount: 2000,
      method: "Online",
      status: "Pending",
    },
  ];
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
          {rows.map((row) => (
            <TableRow key={row.id}>
              <TableCell className="tableCell">{row.id}</TableCell>
              <TableCell className="tableCell">{row.customer}</TableCell>
              <TableCell className="tableCell">{row.amount}</TableCell>
              <TableCell className="tableCell">{row.method}</TableCell>
              <TableCell className="tableCell">
                <span className={`status ${row.status}`}>{row.status}</span>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default List;
