package com.abdul.ecommerce.repo;

import com.abdul.ecommerce.repo.model.Receipt;
import com.abdul.ecommerce.repo.model.OrderDetails;

/**
 * Created by abdul on 9/5/17.
 */
public interface ReceiptDao {
    public Receipt getReceipt(int id);
    public OrderDetails getReceiptOrder(int id);

}
