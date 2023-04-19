import "./datatable.scss";
import { DataGrid } from "@mui/x-data-grid";
import { useState, useEffect } from "react";
import Products from "../../service/Products";

const Datatable = () => {
  const [products, setProducts] = useState({
    products: [],
  });

  const columns = [
    { field: "id", headerName: "ID", width: 280 },
    { field: "name", headerName: "Product Name", width: 150 },
    { field: "price", headerName: "Price", width: 130 },
    { field: "ecategory", headerName: "Category", width: 130 },
  ];
  const rows = products.products;
  console.log(rows);
  const token =
    "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJNYW0iLCJpZCI6MSwiZXhwIjoxNjgxOTA5MDY0LCJpYXQiOjE2ODE5MDM2NjR9.puk9VcGEQYFl3YpLNlbGiZV8HWJzimg4Da2obNVTMNPvTZf2zDJQEUyVNQPwgb-VsJTZAetKcdC_m8FmOdthng";

  useEffect(() => {
    Products.getAllProducts(token).then(
      (response) => {
        setProducts(() => ({
          products: response.data,
        }));
      },
      () => {}
    );
  }, []);

  return (
    <div className="datatable">
      <DataGrid
        rows={rows}
        columns={columns}
        pageSize={10}
        rowsPerPageOptions={[0]}
        checkboxSelection
      />
    </div>
  );
};

export default Datatable;
