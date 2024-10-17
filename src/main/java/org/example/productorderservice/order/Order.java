package org.example.productorderservice.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.productorderservice.product.Product;
import org.springframework.util.Assert;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private int quantity;

    public Order(Product product, int quantity) {
        Assert.notNull(product, "product must be provided");
        Assert.isTrue(quantity > 0, "quantity must be greater than 0");
    }

    public int getTotalPrice() {
        return product.getDisCountedPrice() * quantity;
    }

}
