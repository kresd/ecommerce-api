package com.tabeldata.ecommerce.repository;

import com.tabeldata.ecommerce.entity.Checkout;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CheckoutRepository extends PagingAndSortingRepository<Checkout, String> {

}
