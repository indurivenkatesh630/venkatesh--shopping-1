package com.shopping.service;

import java.util.List;

import com.shopping.dao.OrderDAO;
import com.shopping.dto.Order;

public class OrderService 
{
  OrderDAO orderDAO=new OrderDAO();
  public List<Order> allOrderDetails(int custId)
  {
	  return orderDAO.selectOrderDetails(custId);
  }
}
