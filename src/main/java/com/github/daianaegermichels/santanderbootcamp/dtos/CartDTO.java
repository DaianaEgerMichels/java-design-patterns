package com.github.daianaegermichels.santanderbootcamp.dtos;

import java.util.List;

public class CartDTO {
    private Long id;
    private List<CartItemDTO> items;
    private double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
