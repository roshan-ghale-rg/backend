package com.uhcl.amazonsellers.service;

import com.uhcl.amazonsellers.domain.Seller;

public interface UserAuthenticationService {


   boolean saveUser(Seller seller);

   Seller checkUser(Seller seller);

   Seller checkExistingUser(String email);

   Seller update(Seller seller);

   Seller getSellerById(Long sellerId);

}
