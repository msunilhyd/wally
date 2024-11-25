package com.sunil.service;

import com.sunil.domain.AccountStatus;
import com.sunil.model.Seller;

import java.util.List;

public interface SellerService {

    Seller getSellerProfile(String jwt);

    Seller createSeller(Seller seller);

    Seller getSellerById(Long id);

    Seller getSellerByEmail(String email);

    List<Seller> getAllSellers(AccountStatus status);

    Seller updateSeller(Long id, Seller seller);

    void deleteSeller(Long id);

    String verifyEmail(String email, String otp);

    Seller updateSellerAccountStatus(Long id, AccountStatus status);
}
