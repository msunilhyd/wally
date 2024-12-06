package com.sunil.repository;


import com.sunil.domain.AccountStatus;
import com.sunil.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Seller findByEmail(String email);

    List<Seller> findByAccountStatus(AccountStatus accountStatus);
}
