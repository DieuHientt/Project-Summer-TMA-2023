package com.alibou.project2023TMA.service.Impl;

import com.alibou.project2023TMA.entity.card;
import com.alibou.project2023TMA.entity.card_brand;
import com.alibou.project2023TMA.repository.cardRepository;
import com.alibou.project2023TMA.repository.card_brandRepository;
import com.alibou.project2023TMA.service.cardService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
@Service
public class cardServiceImp implements cardService {
    @Autowired
    private cardRepository cardRepository;
    @Autowired
    public cardServiceImp(cardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    public List<card> getAllCard() {
        return cardRepository
                .findAll();
    }
    @Override
    public card saveCard(card card) {
        cardRepository.save(card);
        return card;
    }

    @Override
    public Object getCard(BigInteger cardId) {
        return cardRepository
                .findById(cardId)
                .orElse(null);
    }
    @Override
    public void deleteCard(BigInteger cardId) {
        cardRepository.deleteById(cardId);
    }

    @Override
    public card updateCard(BigInteger cardId, Map<String, String> formData) {
        card existingCard = cardRepository.findById(cardId).orElse(null);
        if (existingCard != null) {
            String amount = formData.get("amount");
            String cardNumber = formData.get("card_number");
            String symbol = formData.get("symbol");
            existingCard.setAmount(Integer.parseInt(amount));
            existingCard.setCard_number(cardNumber);
            existingCard.setSymbol(symbol);
            String status = formData.get("status");
            existingCard.setStatus(status);
            return cardRepository.save(existingCard);
        }
        return null;
    }

    @Override
    public List<card> getCardNotDeleted() {
        return cardRepository.findCardNotDeleted();
    }


}
