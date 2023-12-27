import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { Button, Card, Image, Icon, CardContent, Header, TextArea } from "semantic-ui-react";
import ProductService from "../services/productServices";

export default function ProductDetail() {
  let { id } = useParams();
  const [product, setProduct] = useState({});
  useEffect(() => {
    let productService = new ProductService();
    productService
      .getProductsById(id)
      .then((result) => setProduct(result.data));
  }, []);
  return (
    <Card.Group>
      <Card fluid>
        <Image src={product.thumbnail} size="large" rounded centered />
        <Card.Content>
          <Card.Header>{product.title}</Card.Header>
          <Card.Meta>{product.brand}</Card.Meta>
          <Card.Description>{product.description}</Card.Description>
        </Card.Content>
        <Card.Content extra>
          <a>
            {product.rating}
            <Icon name="star" />
          </a>
        </Card.Content>
        <CardContent font-size="large">
            {product.price}
            <Icon name="dollar" /> 
        </CardContent>
        <Card.Content extra>
          <div className="ui two buttons">
            <Button basic color="green">
              Sepete Ekle
            </Button>
            <Button basic color="red">
              Sepetten Çıkar
            </Button>
          </div>
        </Card.Content>
      </Card>
    </Card.Group>
  );
}
