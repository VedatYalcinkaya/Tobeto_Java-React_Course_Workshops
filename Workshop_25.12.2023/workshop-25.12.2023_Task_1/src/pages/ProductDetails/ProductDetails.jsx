import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

export default function ProductDetails() {
  let { id } = useParams();
  const [product, setProduct] = useState({});

  const getProductById = async (id) => {
    let response = await axios.get(`https://dummyjson.com/products/${id}`);
    setProduct(response.data);
    console.log(response.data);
  };

  useEffect(() => {
    getProductById(id);
  }, [id]); // useEffect'in dependency array'ine id ekleyerek, id değiştiğinde useEffect'in tekrar çalışmasını sağlıyoruz

  return (
    <div className="card mb-3">
      <div className="row g-0">
        <div className="col-md-5">
          <img src={product.thumbnail} className="img-fluid rounded mx-auto d-block" alt={product.title} />
        </div>
        <div className="col-md-7">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">{product.title}</h5>
              <p className="card-text">
                {product.description}
              </p>
            </div>
            <ul className="list-group list-group-flush">
              <li className="list-group-item">Marka: {product.brand}</li>
              <li className="list-group-item">Kategori: {product.category}</li>
              <li className="list-group-item">Değerlendirme: 5/{product.rating}</li>
              <li className="list-group-item">Stok adeti: {product.stock}</li>
            </ul>
            <div className="card-body">
            <big>Fiyat: {product.price} $</big>
            </div>
            <div className="card-body">
            <button type="button" className="btn btn-success">Sepete Ekle (Pek Yakında)</button>
            <button type="button" className="btn btn-danger mx-3">Ürünü Sil</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
