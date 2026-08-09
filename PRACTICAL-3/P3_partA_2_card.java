public class P3_partA_2_card {
    private String rank;
    private String suit;

    P3_partA_2_card(String rank,String suit) {
        this.rank=rank;
        this.suit=suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public boolean equals(Object o) {
        P3_partA_2_card c=(P3_partA_2_card)o;

        if(rank.equals(c.rank) && suit.equals(c.suit))
            return true;

        return false;
    }

    public int hashCode() {
        return rank.hashCode()+suit.hashCode();
    }
}