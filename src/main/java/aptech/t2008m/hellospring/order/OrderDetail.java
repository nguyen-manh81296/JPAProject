package aptech.t2008m.hellospring.order;

import aptech.t2008m.hellospring.many2many.usercompositekey.StudentGrade;
import aptech.t2008m.hellospring.product.Product;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orders_details")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
    // thông tin thêm.

    private int quantity;
    private double unitPrice;

}
