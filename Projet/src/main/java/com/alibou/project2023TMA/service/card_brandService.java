package com.alibou.project2023TMA.service;


import com.alibou.project2023TMA.entity.card_brand;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public interface card_brandService {

    List<card_brand> getCardBrandActive();
    List<card_brand> getAllCardBrand();
    card_brand saveCardBrand(card_brand cardBrand);

    Object getCardBrand(BigInteger cardBrandId);

    void deleteCardBrand(BigInteger cardBrandId);

    card_brand updateCardBrand(BigInteger cardBrandId, Map<String, String> formData);
    List<card_brand> getCardBrandNotDeleted();

}