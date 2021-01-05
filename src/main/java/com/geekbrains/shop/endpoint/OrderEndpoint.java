package com.geekbrains.shop.endpoint;

import com.geekbrains.shop.api.order.GetOrderRequest;
import com.geekbrains.shop.api.order.GetOrderResponse;
import com.geekbrains.shop.api.order.OrderInfo;
import com.geekbrains.shop.dto.OrderDto;
import com.geekbrains.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;

@Endpoint
public class OrderEndpoint {
    private static final String NAMESPACE_URL = "http://com/example/demo/api/order";
    private final OrderService orderService;

    @Autowired
    public OrderEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getOrderRequest")
    @ResponsePayload
    public GetOrderResponse getOrder(@RequestPayload GetOrderRequest request) throws DatatypeConfigurationException {
        OrderDto orderDto = orderService.getOrderDtoById(request.getId());
        GetOrderResponse response = new GetOrderResponse();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setAmount(orderDto.getAmount());
        orderInfo.setCreated(getXmlGregorianCalendarFromLocalDate(orderDto.getCreated()));
        orderInfo.setStatus(orderDto.getStatus().toString());
        orderInfo.setUsername(orderDto.getUsername());
        orderInfo.setId(orderDto.getId());
        orderInfo.setSum(orderDto.getSum());
        response.setOrder(orderInfo);
        return response;
    }

    private XMLGregorianCalendar getXmlGregorianCalendarFromLocalDate(LocalDateTime localDateTime) throws DatatypeConfigurationException {
        XMLGregorianCalendar xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar();
        xmlCal.setYear(localDateTime.getYear());
        xmlCal.setMonth(localDateTime.getMonthValue());
        xmlCal.setDay(localDateTime.getDayOfMonth());
        xmlCal.setHour(localDateTime.getHour());
        xmlCal.setMinute(localDateTime.getMinute());
        xmlCal.setSecond(localDateTime.getSecond());
        return xmlCal;
    }

}
