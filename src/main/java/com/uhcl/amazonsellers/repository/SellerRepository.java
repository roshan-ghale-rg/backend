package com.uhcl.amazonsellers.repository;

import com.uhcl.amazonsellers.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SellerRepository extends JpaRepository<Seller, Long> {

    Seller findByEmail(String username);

}
