import {Routes, Route} from "react-router-dom";
import "./App.css";
import Homepage from "./pages/Homepage/Homepage";
import About from "./pages/About/About";
import Navbar from "./components/Navbar/Navbar";
import ProductDetails from "./pages/ProductDetails/ProductDetails";
import ProductAdd from "./pages/ProductAdd/ProductAdd";

function App() {
	return (
		<>
			<Navbar />
				<Routes>
					<Route path="/" element={<Homepage />}></Route>
					<Route path="/about" element={<About />}></Route>
					<Route path="*" element={<p>Not Found</p>}></Route>
					<Route path="product-detail/:id" element={<ProductDetails/>}></Route>
					<Route path="product/add" element={<ProductAdd/>}></Route>

				</Routes>
		</>
	);
}
export default App;
