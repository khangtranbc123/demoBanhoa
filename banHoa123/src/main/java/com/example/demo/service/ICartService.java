package com.example.demo.service;



import java.math.BigDecimal;
import java.util.Collection;

import com.example.demo.entity.BillHoa;


public interface ICartService {
	int GetCount();	
	BigDecimal GetAmount();	
	void add(BillHoa billHoa);
	void update(int hoaId, int quantity);
	void clear();
	Collection<BillHoa> getCart();
	void remove(int hoaId);
	public BillHoa finCart(BillHoa billHoa);
	public BillHoa finCart2(int hoaId);
	
//	// them san pham vao gio hang
//		void addToCart(BillHoa hoa, int quantity);
//		
//	// thay doi so luong san pham trong gio
//	void changeProductQuantity(BillHoa hoa, int quantity);
//		
////	// bo 1 san pham trong gio
////	void removeProduct(Optional<Hoa> hoa);
////		
////	// bo tat ca san pham trong gio
////	void removeProducts();
}
