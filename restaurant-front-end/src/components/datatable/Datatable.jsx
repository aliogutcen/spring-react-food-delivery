import "./datatable.scss";
import { DataGrid } from "@mui/x-data-grid";

const columns = [
  { field: "id", headerName: "ID", width: 70 },
  { field: "firstName", headerName: "First name", width: 130 },
  { field: "lastName", headerName: "Last name", width: 130 },
  {
    field: "age",
    headerName: "Age",
    type: "number",
    width: 90,
  },
];

const rows = [
  { id: 1, productname: "Snow", price: "Jon", age: 35 },
  { id: 2, productname: "Lannister", firstName: "Cersei", age: 42 },
  { id: 3, productname: "Lannister", firstName: "Jaime", age: 45 },
  { id: 4, productname: "Stark", firstName: "Arya", age: 16 },
  { id: 5, productname: "Targaryen", firstName: "Daenerys", age: null },
  { id: 6, productname: "Melisandre", firstName: null, age: 150 },
  { id: 7, productname: "Clifford", firstName: "Ferrara", age: 44 },
  { id: 8, productname: "Frances", firstName: "Rossini", age: 36 },
  { id: 9, productname: "Roxie", firstName: "Harvey", age: 65 },
];

const Datatable = () => {
  return (
    <div className="datatable">
      <DataGrid
        rows={rows}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
      />
    </div>
  );
};

export default Datatable;
