package company.amazon.ood.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

enum Suit {
    HEART, SPADE, CLUB, DIAMOND
}

class Card {
    Suit suit;
    int faceValue;

    public Card(Suit suit, int faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    int getPoints() {
        return Math.min(faceValue, 10);
    }
}

class Deck {
    List<Card> cards = new ArrayList<>();

    public Deck() {
        createDeck();
        shuffle();
    }

    public void createDeck() {
        for (Suit suit : Suit.values()) {
            for (int i = 1; i < 14; i++) {
                cards.add(new Card(suit, i));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card removeCard() {
        if (cards.size() == 0) return null;
        return cards.remove(cards.size() - 1);
    }
}

abstract class Player {
    String name;
    List<Card> hand = new ArrayList<>();

    abstract boolean canPlay();

    abstract boolean wantToPlay();

    public Player(String name) {
        this.name = name;
    }

    int getTotalPoints() {
        int minTotal = 0;
        int maxTotal = 0;
        for (Card card : hand) {
            int points = card.getPoints();
            minTotal += points;
            maxTotal += points == 1 ? 11 : points;
        }
        return maxTotal > 21 ? minTotal : maxTotal;
    }

    void addCard(Card card) {
        hand.add(card);
    }
}

class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    boolean canPlay() {
        return getTotalPoints() < 21;
    }

    @Override
    boolean wantToPlay() {
        return getTotalPoints() < 17;
    }
}

class Dealer extends Player {

    public Dealer(String name) {
        super(name);
    }

    @Override
    boolean canPlay() {
        return getTotalPoints() < 21;
    }

    @Override
    boolean wantToPlay() {
        return true;
    }
}

class Move {
    Player player;
    Card card;

    public Move(Player player, Card card) {
        this.player = player;
        this.card = card;
    }
}

public class BlackJack {
    Deck deck = new Deck();
    private Player dealer = new Dealer("Max");
    private Player player = null;
    List<Move> moves = new ArrayList<>();
    Card hiddenDealerCard = null;

    public BlackJack(String playerName) {
        player = new HumanPlayer(playerName);
    }

    void play() {
        hiddenDealerCard = deck.removeCard();
        giveCard(dealer, deck.removeCard());
        giveCard(player, deck.removeCard());
        while (player.canPlay() && player.wantToPlay() && !gameEnded()) {
            giveCard(player, deck.removeCard());
        }
        if (!gameEnded()) {
            giveCard(dealer, hiddenDealerCard);
            while (dealer.canPlay() && !gameEnded()) {
                giveCard(dealer, deck.removeCard());
            }
        }
        showGameWinner();
    }

    private void showGameWinner() {
        if (player.getTotalPoints() > 21) {
            System.out.println("player lose");
        } else if (dealer.getTotalPoints() > 21) {
            System.out.println("dealer lose");
        } else {
            if (player.getTotalPoints() > dealer.getTotalPoints()) System.out.println("player win");
            else System.out.println("dealer win");
        }
    }

    void giveCard(Player p, Card c) {
        Move move = new Move(p, c);
        moves.add(move);
        p.addCard(c);
    }

    boolean gameEnded() {
        if (player.getTotalPoints() >= 21) return true;
        else if (dealer.getTotalPoints() >= 21) return true;
        return false;
    }
}