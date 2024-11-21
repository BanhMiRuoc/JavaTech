package vn.edu.tdtu.lab10.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.tdtu.lab10.model.Product;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductsDTO {
    private Long order_number;
    private double total_selling_price;
    private List<Product> product_list;
}
