package com.example.Library.Management.System.service;


import com.example.Library.Management.System.dto.request.OrderRequest;
import com.example.Library.Management.System.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getAllOrders(int pageNumber, int pageSize);
    void addOrder(OrderRequest orderRequest);
    void returnOrder(OrderRequest orderRequest);
}
