package com.example.electronic_kits_store.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "seq_order_id", allocationSize = 1)
    private Long id;

    @Column(name = "order_date", updatable = false)
    private LocalDateTime orderDateTime;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @Builder.Default
    private List<OrderItem> orderItems = new ArrayList<>();
    public BigDecimal calculateTotalPrice() {
        BigDecimal price = BigDecimal.valueOf(0);
        for(OrderItem item: orderItems) {
            price =  price.add(BigDecimal.valueOf(item.getQuantity()).multiply(item.getProduct().getCost()));
        }
        totalPrice = price;
        return totalPrice;
    }
    private enum OrderStatus {
        IN_PROCESSING,
        VALIDATED,
        SHOPPED,
        COMPLETED,
        CANCELED
    }

}


