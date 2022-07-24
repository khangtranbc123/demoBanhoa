package com.example.demo.entity;

import java.util.Map;
import java.util.Optional;

public class Cart {
	// Key: ma san pham, Value: so luong san pham
	private Map<BillHoa, Integer> cartDetails;

	public Map<BillHoa, Integer> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(Map<BillHoa, Integer> cartDetails) {
		this.cartDetails = cartDetails;
	}







	
	

}
