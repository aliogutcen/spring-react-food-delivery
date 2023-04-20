import { useState, useEffect } from "react";
import Products from "./service/Products";

function Category() {
  let [category, setCategory] = useState({
    category: [],
  });

  useEffect(() => {
    Products.getAllCategories().then(
      (response) => {
        setCategory(() => ({
          category: response.data,
        }));
      },
      () => {}
    );
  }, []);
}

export default Category;
