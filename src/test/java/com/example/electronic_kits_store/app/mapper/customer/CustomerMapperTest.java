package com.example.electronic_kits_store.app.mapper.customer;

import com.example.electronic_kits_store.app.dto.customer.CustomerDTO;
import com.example.electronic_kits_store.app.dto.order.OrderDTO;
import com.example.electronic_kits_store.app.dto.order.OrderItemDTO;
import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.model.Customer;
import com.example.electronic_kits_store.app.model.Order;
import com.example.electronic_kits_store.app.model.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerMapperTest {
    private final CustomerMapper mapper = new CustomerMapperImpl();

    @Test
    void shouldProperlyMapEntityToDto() {

        //given
        Customer customer =Customer.builder()
                .id(42L)
                .firstName("John")
                .lastName("Dou")
                .email("j.dou@gmail.com")
                .phoneNumber("+380961234523")
                .password("strongPassword")
                .build();

        Battery battery = getBattery();

        OrderItem orderItem1 = OrderItem
                .builder()
                .id(12L)
                .product(battery)
                .quantity(2)
                .build();

        Order order1 = new Order();
        order1.setId(1L);
        LocalDateTime orderTime = LocalDateTime.now();
        order1.setOrderDateTime(orderTime);
        order1.setOrderStatus(Order.OrderStatus.IN_PROCESSING);
        order1.addOrderItem(orderItem1);
        order1.calculateTotalPrice();

        customer.addOrder(order1);

        OrderItemDTO expectedOrderItemDTO = new OrderItemDTO(2, 45L);
        List<OrderItemDTO> expectedListOfOrderItem = new ArrayList<>();
        expectedListOfOrderItem.add(expectedOrderItemDTO);

        OrderDTO expectedOrderDTO = new OrderDTO(
                1L,
                orderTime,
                BigDecimal.valueOf(111200).multiply(BigDecimal.valueOf(2)),
                "IN_PROCESSING",
                expectedListOfOrderItem
        );

        CustomerDTO expectedCustomerDto = new CustomerDTO(
                "John", "Dou", "j.dou@gmail.com", "+380961234523",
                Collections.singletonList(expectedOrderDTO));


        //when
        CustomerDTO customerDTO = mapper.toDto(customer);


        //then
        assertNotNull(customerDTO);
        assertEquals(customerDTO.firstName(), expectedCustomerDto.firstName());
        assertEquals(customerDTO.lastName(), expectedCustomerDto.lastName());
        assertEquals(customerDTO.email(), expectedCustomerDto.email());
        assertEquals(customerDTO.phoneNumber(), expectedCustomerDto.phoneNumber());
        assertIterableEquals(customerDTO.orders(), expectedCustomerDto.orders());
    }

    private static Battery getBattery() {
        Battery battery = new Battery();
        battery.setId(45L);
        battery.setName("The BestBattery 12V!");
        battery.setCost(BigDecimal.valueOf(111200));
        battery.setManufacturer("China");
        battery.setDescription("high performance lion battery 12 V");
        battery.setRating((byte) 3);
        battery.setPictureUrl("/111200.jpg");
        battery.setNominalVoltage(12);
        battery.setCapacity(3000);
        battery.setForm(Battery.FormFactor.PRISMATIC);
        battery.setBatteryTerminalDiameter(12);
        return battery;
    }
}
