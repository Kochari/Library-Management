package com.example.Library.Management.System.service.serviceImpl;

import com.example.Library.Management.System.dto.request.OrderRequest;
import com.example.Library.Management.System.dto.response.OrderResponse;
import com.example.Library.Management.System.entity.Order;
import com.example.Library.Management.System.exception.NotFoundException;
import com.example.Library.Management.System.mapper.OrderMapper;
import com.example.Library.Management.System.repository.OrderRepository;
import com.example.Library.Management.System.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderResponse> getAllOrders(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Order> orders = orderRepository.findAll(pageable);
        if (orders.getTotalElements() <= 0) {
            throw new NotFoundException("Order Not Found");
        }
        return orderRepository
                .findAll()
                .stream()
                .map(orderMapper::OrderToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void addOrder(OrderRequest orderRequest) {

    }

    @Override
    public void returnOrder(OrderRequest orderRequest) {

    }
}
