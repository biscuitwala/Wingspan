package GameOfHearts;
import java.util.Random; 

public class Deck {
    //Initializes an array of 52 Cards.
    Card deck[] = new Card[52];
    
    //Initializes an array of four hands with thirteen Cards each.
    Card hands[][] = new Card[13][4];
    
    //Initializes the values for the deck.
    void createDeck() {
        for (int i = 0; i < 52; i++){
            deck[i] = new Card();
        }
        for (int i = 0; i < 13; i++) {
            deck[i].setSuit("Spade");
            deck[i].setNum(i + 1);
            deck[i].setDesc();
        }
        for (int i = 13; i < 26; i++) {
            deck[i].setSuit("Heart");
            deck[i].setNum(i - 12);
            deck[i].setDesc();
        }
        for (int i = 26; i < 39; i++) {
            deck[i].setSuit("Club");
            deck[i].setNum(i - 25);
            deck[i].setDesc();
        }
        for (int i = 39; i < 52; i++) {
            deck[i].setSuit("Diamond");
            deck[i].setNum(i - 38);
            deck[i].setDesc();
        }
    }
    
    //Deals the hands, one card to each player consecutively, thirteen times.
    void dealHands() {
        int counter = 0;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                hands[i][j] = deck[counter];
                counter++;
            }
        }
    }
    Deck() {
        createDeck();
    }

    //Shuffles the deck. An array of 52 random integers is created. Each integer 
    //represents a position on the array. We iterate through each consecutive
    //position on the deck and switch that with the position from the random
    //positions array. 
    void shuffle() {
        int randNums[] = new int[52];
        for (int i = 0; i < 52; i++) {
            Random rand = new Random();
            int randNum = rand.nextInt(52);
            randNums[i] = randNum;
        }
        for (int i = 0; i < 52; i++) {
            Card temp = deck[i];
            deck[i] = deck[randNums[i]];
            deck[randNums[i]] = temp;
        }
    }
    
    //Bubble sort to organize hands.
    void sortHands() {
        Boolean madeSwap;
        for (int j = 0; j < 4; j++) {
            do {
                madeSwap = false;
                for (int count = 0; count < 12; count++) {
                    if (hands[count][j].isLessThan(hands[count + 1][j])) {
                        Card temp = hands[count][j];
                        hands[count][j] = hands[count + 1][j];
                        hands[count + 1][j] = temp;
                        madeSwap = true;
                    }
                }
            } while (madeSwap);
        }
    }
    
    void displayHands() {
        System.out.println(spacer("Hand 1") + spacer("Hand 2") + spacer("Hand 3")
                + spacer("Hand 4"));
        System.out.println(spacer("______") + spacer("______") + spacer("______")
                + spacer("______"));
        for (int i = 0; i < 13; i++) {
            System.out.println(spacer(hands[i][0].getDesc()) + 
                    spacer(hands[i][1].getDesc()) +
           spacer(hands[i][2].getDesc()) + spacer(hands[i][3].getDesc())); 
        }
        System.out.println();
    }
    String spacer(String text) {
        String spacer = " ";
        for (int i = 0; i < 19 - (text.length()) - 1; i++ ){
            spacer += " ";
        }
        return text + spacer;
    }
}
