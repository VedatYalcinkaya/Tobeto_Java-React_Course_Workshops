import React, { useEffect, useState } from "react";
import Categories from "./Categories";
import ProductList from "../pages/ProductList";
import { Grid } from "semantic-ui-react";
import { Route, Router, Routes } from "react-router-dom";
import ProductDetail from "../pages/ProductDetail";
import CartDetail from "../pages/CartDetail";

export default function Dashboard() {
  const [toDoText, setToDoText] = useState("");
  const [toDoList, setToDoList] = useState([]);

  const addToDo = () => {
    if (toDoText.trim() !== "") {
      setToDoList([...toDoList, toDoText]);
      setToDoText("");
    }
  };

  const deleteToDo = (index) => {
    // Filter ile seçilen to-do dışındaki diğerlerini içeren yeni bir liste oluştur
    const updatedToDoList = toDoList.filter((_, i) => i !== index);
    setToDoList(updatedToDoList);
  };

  useEffect(() => {
    console.log("To-do eklendi");
  }, [toDoList]);

  return (
    <div>
      <Grid>
        <Grid.Row>
          <Grid.Column width={4}>
            <Categories />
          </Grid.Column>
          <Grid.Column width={12}>
            <Routes>
              <Route path="/" Component={ProductList}/>
              <Route path="/products" Component={ProductList}/>
              <Route path="products/:id" Component={ProductDetail}/>
              <Route path="cart" Component={CartDetail}/>
            </Routes>
          </Grid.Column>
        </Grid.Row>
      </Grid>
    </div>
  );
}
