package com.tabeldata.ecommerce.repository;

import com.tabeldata.ecommerce.entity.TransaksiDetails;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransaksiDetailRepository extends PagingAndSortingRepository<TransaksiDetails, String> {
}
