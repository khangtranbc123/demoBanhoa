package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.BillHoa;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Hoa;
import com.example.demo.service.ICartService;

@Service
@SessionScope
public class CartServiceImpl implements ICartService {

	private Map<Integer, BillHoa> map = new HashMap<Integer, BillHoa>();
	@Override
	public int GetCount() {
		return map.values().size();
	}
	
	@Override
	public BillHoa finCart(BillHoa billHoa) {
		 BillHoa billHoaed = map.get(billHoa.getHoaId());
		 return billHoaed;
	}
	
	@Override
	public BillHoa finCart2(int hoaId) {
		BillHoa billHoaed = map.get(hoaId);
		 return billHoaed;
	}
	
	@Override
	public BigDecimal GetAmount() {
		//return map.values().stream().flatMap(billHoa->billHoa.getSoLuong()*billHoa.getGia()).sum();
		return null;
	}

	@Override
	public void add(BillHoa billHoa) {
		BillHoa billHoaed = map.get(billHoa.getHoaId());
		if (billHoaed != null) {
			billHoaed.setSoLuong(billHoa.getSoLuong() + billHoaed.getSoLuong());
		}else {map.put(billHoa.getHoaId(), billHoa); }
	}

	@Override
	public void update(int hoaId, int soLuong) {
		BillHoa billHoa = map.get(hoaId);
		
		billHoa.setSoLuong(soLuong);
		if (billHoa.getSoLuong() <= 0) {
			map.remove(hoaId);
			
		}
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Collection<BillHoa> getCart() {
		return map.values();
	}

	@Override
	public void remove(int hoaId) {
		map.remove(hoaId);
	}


	
	

	
}
