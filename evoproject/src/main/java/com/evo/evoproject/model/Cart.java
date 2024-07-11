package com.evo.evoproject.model;

import lombok.Data;
import java.util.List;

@Data
public class Cart {
    private int cartId;
    private int userNo;
    private int cartQuantity;
    private List<Product> products;
}
