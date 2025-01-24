package com.example.Library.Management.System.mapper;

import com.example.Library.Management.System.dto.request.OrderRequest;
import com.example.Library.Management.System.dto.response.OrderResponse;
import com.example.Library.Management.System.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderResponse toOrderResponse(Order order);

    Order toOrder(OrderRequest orderRequest);
}
