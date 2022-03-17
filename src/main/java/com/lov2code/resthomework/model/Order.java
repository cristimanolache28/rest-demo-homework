package com.lov2code.resthomework.model;

import com.lov2code.resthomework.exception.InvalidQuantityException;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
public class Order {

    private Long id;

    @NotNull
    private int petId;

    @NotNull
    private int quantity;

    @NotNull
    private Date shipDate;

    @NotNull
    @Size(min = 2, max = 10)
    private String status;

    @NotNull
    private boolean complete;

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setQuantity(int quantity) throws InvalidQuantityException{
        if (quantity > 0) {
            this.quantity = quantity;
        }
        else {
            throw new InvalidQuantityException("The quantity must be greater than 1.");
        }
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
