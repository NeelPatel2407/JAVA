public class P3_partA_2_driver {
    public static void main(String[] args) {
        P3_partA_2_card[] cards={
            new P3_partA_2_card("Ace","Hearts"),
            new P3_partA_2_card("King","Spades"),
            new P3_partA_2_card("Ace","Spades"),
            new P3_partA_2_card("Queen","Hearts"),
            new P3_partA_2_card("Ace","Spades")
        };

        for(int i=0;i<cards.length;i++) {
            for(int j=0;j<i;j++) {
                if(cards[i].equals(cards[j])) {
                    System.out.println("Duplicate found: " + cards[i]);
                    return;
                }
            }
        }
    }
}