
package com.example.demo.services;

import com.example.demo.entities.Card;
import com.example.demo.entities.Column;
import com.example.demo.repositories.CardRepository;
import com.example.demo.repositories.ColumnRepository;

public class ColumnService {

     private final ColumnRepository columnRepository;
     private final CardRepository cardRepository;

     public ColumnService(ColumnRepository columnRepository, CardRepository cardRepository) {
          this.columnRepository = columnRepository;
          this.cardRepository = cardRepository;
     }

     /**
      * Adds a new card to the specified column.
      *
      * @param columnId The ID of the column where the card will be added.
      * @param cardTitle The title of the card.
      * @return The newly created Card object.
      * @throws RuntimeException if the column with the given ID does not exist.
      */
     public Card addCard(Long columnId, String cardTitle) {
          Card card = new Card(cardTitle);
          Card saveCard = cardRepository.save(card);

          Column column = columnRepository.findById(columnId).orElseThrow(()->new RuntimeException("Column with an id " + columnId + " does not exist"));
          column.addCard(saveCard);
          saveCard.setColumn(column);
          return saveCard;
     }

     /**
      * Moves a card from its current column to the specified target column.
      *
      * @param cardId The ID of the card to be moved.
      * @param targetColumnId The ID of the target column where the card will be moved.
      * @return true if the card is successfully moved, false otherwise.
      * @throws RuntimeException if the card, current column, or target column doesn't exist, or if
      *         the card is not in any column.
      */
     public Boolean moveCard(Long cardId, Long targetColumnId) {
          Card card = cardRepository.findById(cardId).orElseThrow(() -> new RuntimeException("Card with an id " + cardId + " does not exist"));
          Column targetColumn = columnRepository.findById(targetColumnId).orElseThrow(() -> new RuntimeException("Column with an id " + targetColumnId + " does not exist"));
          Column originalColumn = card.getColumn();
          if(originalColumn==null || targetColumn==null || targetColumn.getBoard().getId() != originalColumn.getBoard().getId())
               throw new RuntimeException("Current column and target column with an id " + targetColumnId + " do not belong to the same board");
          
          // Card newCard = new Card(cardId, card);
          // Card savedCard = cardRepository.save(newCard);

          //setting the target_column refference on the card 
          card.setColumn(targetColumn);
          //adding the new card on the target_column
          targetColumn.addCard(card);

          //deleting the card from the original_column
          originalColumn.removeCard(card);
          
          return true;
     }
}
