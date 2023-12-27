import React, { useState } from "react";
import axios from "axios";

export default function ProductAdd() {
  const [product, setProduct] = useState({
    title: "",
    description: "",
    brand: "",
    category: "",
    rating: 0,
    stock: 0,
    price: 0,
    img: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct((prevProduct) => ({
      ...prevProduct,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("https://dummyjson.com/products/add", product);
      console.log("Ürün başarıyla eklendi:", response.data);
    } catch (error) {
      console.error("Ürün eklenirken bir hata oluştu:", error);
    }
  };

  return (
    <div>
      <h2>Ürün Ekle</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="title" className="form-label">Başlık:</label>
          <input
            type="text"
            className="form-control"
            id="title"
            name="title"
            value={product.title}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="description" className="form-label">Açıklama:</label>
          <textarea
            className="form-control"
            id="description"
            name="description"
            value={product.description}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="brand" className="form-label">Marka:</label>
          <input
            type="text"
            className="form-control"
            id="brand"
            name="brand"
            value={product.brand}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="category" className="form-label">Kategori:</label>
          <input
            type="text"
            className="form-control"
            id="category"
            name="category"
            value={product.category}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="rating" className="form-label">Değerlendirme:</label>
          <input
            type="number"
            className="form-control"
            id="rating"
            name="rating"
            value={product.rating}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="stock" className="form-label">Stok:</label>
          <input
            type="number"
            className="form-control"
            id="stock"
            name="stock"
            value={product.stock}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="price" className="form-label">Fiyat:</label>
          <input
            type="number"
            className="form-control"
            id="price"
            name="price"
            value={product.price}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="img" className="form-label">Resim URL:</label>
          <input
            type="text"
            className="form-control"
            id="img"
            name="img"
            value={product.img}
            onChange={handleChange}
          />
        </div>
        <button type="submit" className="btn btn-primary">Ekle</button>
      </form>
    </div>
  );
}
