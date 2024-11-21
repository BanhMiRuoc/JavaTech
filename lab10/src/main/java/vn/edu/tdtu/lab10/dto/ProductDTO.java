package vn.edu.tdtu.lab10.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long code;
    private String productName;
    private double price;
    private String description;
    private byte[] image;
}
