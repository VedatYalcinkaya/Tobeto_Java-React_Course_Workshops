import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";

export default function ProductCard(props) {
  const handleDelete = async () => {
    try {
      const productToDelete = await axios.delete(`https://dummyjson.com/products/${props.product.id}`);
	  console.log(productToDelete.data);
      console.log("Ürün başarıyla silindi.");
    } catch (error) {
      console.error("Ürün silinirken bir hata oluştu:", error);
    }
  };
  return (
    <div className="card">
      <img src={props.product.thumbnail} className="card-img-top" alt="..." />
      <div className="card-body">
        <h5 className="card-title">{props.product.title}</h5>
        <p className="card-text">{props.product.description}</p>
        <Link
          to={`/product-detail/${props.product.id}`}
          className="btn btn-primary"
        >
          Details
        </Link>
        <button onClick={handleDelete} className="btn btn-danger">
          Sil
        </button>
      </div>
    </div>
  );
}
