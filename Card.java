public class Card {

    //data variables

    private String suit;
    private int value;
    private String rank;
    private String picName;
   


    public Card() {
        suit = "heart";
        value = 10;
    }


    public Card(String suit, String rank, int value, String picName) {
        this.suit = suit;
        this.value = value;
        this.rank = rank;
        this.picName = picName;
       
    }
            //Setters
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public void setPicName(String picName) {
        this.picName = picName;
    }


            //Getters
    public String getSuit() {
        return suit;
    }
   
    public int getValue() {
        return value;
    }
    public String getRank() {
        return rank;
    }
    public String getPicName() {
        return picName;
    }


    public boolean equals (Card other) {
        return rank.equals(other.rank) && value == other.value;
    }


        //toString Method
      public String toString() {
        return " suit " + suit + " value " + value + " rank " + rank + " picName " + picName;
    }
   
}

