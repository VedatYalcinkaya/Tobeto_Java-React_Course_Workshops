import React, { useState, useEffect } from "react";
import { Icon, Menu, Table } from "semantic-ui-react";
import ProductService from "../services/productServices";
import { Link } from "react-router-dom";
import ProductDetail from "./ProductDetail";

export default function ProductList() {
  const [products, setProducts] = useState([]);
  useEffect(() => {
    let productService = new ProductService();
    productService.getProducts().then((result) => setProducts(result.data.products));
  },[]);

  return (
    <div>
      <Table celled>
        <Table.Header>
          <Table.Row>
            <Table.Cell>Title</Table.Cell>
            <Table.Cell>Category</Table.Cell>
            <Table.Cell>Price</Table.Cell>
            <Table.Cell>Discount Percentage</Table.Cell>
            <Table.Cell>Rating</Table.Cell>
            <Table.Cell>Stock</Table.Cell>
            <Table.Cell>Brand</Table.Cell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {products.map((product) => (
            <Table.Row key={product.id}>
              <Table.Cell><Link to={`/products/${product.id}`}>{product.title}</Link></Table.Cell>
              <Table.Cell>{product.category}</Table.Cell>
              <Table.Cell>{product.price}</Table.Cell>
              <Table.Cell>{product.discountPercentage}</Table.Cell>
              <Table.Cell>{product.rating}</Table.Cell>
              <Table.Cell>{product.stock}</Table.Cell>
              <Table.Cell>{product.brand}</Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>

        <Table.Footer>
          <Table.Row>
            <Table.HeaderCell colSpan="3">
              <Menu floated="right" pagination>
                <Menu.Item as="a" icon>
                  <Icon name="chevron left" />
                </Menu.Item>
                <Menu.Item as="a">1</Menu.Item>
                <Menu.Item as="a">2</Menu.Item>
                <Menu.Item as="a">3</Menu.Item>
                <Menu.Item as="a">4</Menu.Item>
                <Menu.Item as="a" icon>
                  <Icon name="chevron right" />
                </Menu.Item>
              </Menu>
            </Table.HeaderCell>
          </Table.Row>
        </Table.Footer>
      </Table>
    </div>
  );
}
