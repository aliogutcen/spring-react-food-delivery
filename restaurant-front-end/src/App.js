import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import "./App.css";
import { AuthContext } from "./context/AuthContext";
import { useContext } from "react";
import Home from "./pages/home/Home";
import Register from "./pages/register/Register";
import Login from "./pages/login/Login";
import List from "./pages/list/List";
import Singlepage from "./pages/singlepage/Singlepage";
import New from "./pages/new/New";

function App() {
  const { currentUser } = useContext(AuthContext);
  const RequiredAuth = ({ children }) => {
    return currentUser ? children : <Navigate to="/login" />;
  };
  console.log(currentUser);
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/">
          <Route index element={<Home />} />
          <Route path="login" element={<Login />} />
          <Route path="restaurant">
            <Route index element={<List />} />
            <Route path=":userId" element={<Singlepage />} />
            <Route path="new" element={<New />} />
          </Route>
          <Route path="products">
            <Route index element={<List />} />
            <Route path=":productId" element={<Singlepage />} />
            <Route path="new" element={<New />} />
          </Route>
          <Route path="register" element={<Register />} />
        </Route>
      </Routes>
    </BrowserRouter>

    //
  );
}

export default App;
