package com.sunil.service.impl;

import com.sunil.config.JwtProvider;
import com.sunil.domain.AccountStatus;
import com.sunil.domain.USER_ROLE;
import com.sunil.model.Address;
import com.sunil.model.Seller;
import com.sunil.repository.AddressRepository;
import com.sunil.repository.SellerRepository;
import com.sunil.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    private final JwtProvider jwtProvider;

    private final PasswordEncoder passwordEncoder;

    private final AddressRepository addressRepository;

    @Override
    public Seller getSellerProfile(String jwt) throws Exception {

        String email = jwtProvider.getEmailFromJwtToken(jwt);
        return this.getSellerByEmail(email);
    }

    @Override
    public Seller createSeller(Seller seller) throws Exception {
        Seller sellerDb = sellerRepository.findByEmail(seller.getEmail());
        if (sellerDb != null)
            throw new Exception("Seller already exists, with this email:- " + seller.getEmail());
        Address savedAddress = addressRepository.save(seller.getPickupAddress());

        Seller newSeller = new Seller();
        newSeller.setEmail(seller.getEmail());
        newSeller.setPassword(passwordEncoder.encode(seller.getPassword()));
        newSeller.setName(seller.getName());
        newSeller.setPickupAddress(seller.getPickupAddress());
        seller.setGSTIN(seller.getGSTIN());
        newSeller.setRole(USER_ROLE.ROLE_SELLER);
        newSeller.setBankDetails(seller.getBankDetails());
        newSeller.setBusinessDetails(seller.getBusinessDetails());

        return sellerRepository.save(newSeller);
    }

    @Override
    public Seller getSellerById(Long id) throws Exception {
        return sellerRepository.findById(id).orElseThrow(() -> new Exception("Seller not found with id :- " + id));
    }

    @Override
    public Seller getSellerByEmail(String email) throws Exception {
        Seller seller = sellerRepository.findByEmail(email);
        if (seller == null)
            throw new Exception("seller not found with email:- " + email);
        return seller;
    }

    @Override
    public List<Seller> getAllSellers(AccountStatus status) {
        return sellerRepository.findByAccountStatus(status);
    }

    @Override
    public Seller updateSeller(Long id, Seller seller) throws Exception {

        Seller existingSeller = this.getSellerById(id);

        if (seller.getName() != null) {
            existingSeller.setName(seller.getName());
        }
        if (seller.getMobile() != null) {
            existingSeller.setMobile(seller.getMobile());
        }
        if (seller.getEmail() != null) {
            existingSeller.setEmail(seller.getEmail());
        }
        if (seller.getBusinessDetails() != null && seller.getBusinessDetails().getBusinessName() != null) {
            existingSeller.getBusinessDetails().setBusinessName(seller.getBusinessDetails().getBusinessName());
        }
        if (seller.getBankDetails() != null && seller.getBankDetails().getAccountHolderName() != null && seller.getBankDetails().getIfscCode() != null && seller.getBankDetails().getAccountNumber() != null) {
            existingSeller.getBankDetails().setAccountHolderName(seller.getBankDetails().getAccountHolderName());
            existingSeller.getBankDetails().setIfscCode(seller.getBankDetails().getIfscCode());
            existingSeller.getBankDetails().setAccountNumber(seller.getBankDetails().getAccountNumber());
        }
        if (seller.getPickupAddress() != null && seller.getPickupAddress().getAddress() != null && seller.getPickupAddress().getCity() != null && seller.getPickupAddress().getState() != null & seller.getPickupAddress().getMobile() != null) {
            existingSeller.getPickupAddress().setCity(seller.getPickupAddress().getCity());
            existingSeller.getPickupAddress().setAddress(seller.getPickupAddress().getAddress());
            existingSeller.getPickupAddress().setState(seller.getPickupAddress().getState());
            existingSeller.getPickupAddress().setMobile(seller.getPickupAddress().getMobile());
        }
        if (seller.getGSTIN() != null) {
            existingSeller.setGSTIN(seller.getGSTIN());
        }

        return sellerRepository.save(existingSeller);
    }

    @Override
    public void deleteSeller(Long id) throws Exception {
        Seller seller = getSellerById(id);
        sellerRepository.delete(seller);
    }

    @Override
    public Seller verifyEmail(String email, String otp) throws Exception {
        Seller seller = getSellerByEmail(email);
        seller.setEmailVerified(true);
       return sellerRepository.save(seller);
    }

    @Override
    public Seller updateSellerAccountStatus(Long id, AccountStatus status) throws Exception {
        Seller seller = getSellerById(id);
        seller.setAccountStatus(status);

        return sellerRepository.save(seller);
    }
}
