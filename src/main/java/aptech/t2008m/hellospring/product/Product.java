package aptech.t2008m.hellospring.product;

import aptech.t2008m.hellospring.entity.BaseEntity;
import aptech.t2008m.hellospring.entity.Category;
import aptech.t2008m.hellospring.order.Order;
import aptech.t2008m.hellospring.order.OrderDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //Gia tri tu tang
    private int id;
//    @Column(name = "name", columnDefinition = "varchar(250)")
    private String name;
    private String description;
    private Double price;
    private int categoryId;
    private int status;

    @ManyToOne
    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetailSet;

}
