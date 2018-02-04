import java.util.*;

public class Main
{
public static void main(String[] args)
{
List<Card> cards=new ArrayList<Card>();
String[] suits = {"Spade", "Heart", "Diamond", "Club"};
String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
for(int i=0;i<suits.length;++i){
for(int j=0;j<ranks.length;++j){
cards.add(new Card(suits[i],ranks[j]));
}
}
shuffle(cards);
for(int i=0;i<cards.size();++i){
cards.get(i).printCard();
}
}

public static void shuffle(List<Card> list){
for(int i=0;i<list.size()/2;++i){
if((i+1)%2==0){
Card c1=list.get(i);
Card c2=list.get(list.size()/2-1+i);
String tsuit=c1.getSuit();
c1.setSuit(c2.getSuit());
c2.setSuit(tsuit);
String trank=c1.getRank();
c1.setRank(c2.getRank());
c2.setRank(trank);
}
}
}
}

class Card{
String suit="";
String rank="";

Card(String sut,String rnk){
suit=sut;
rank=rnk;
}

public void setRank(String rank)
{
this.rank = rank;
}

public String getRank()
{
return rank;
}

public void setSuit(String suit)
{
this.suit = suit;
}

public String getSuit()
{
return suit;
}

public void printCard(){
System.out.println(suit+" "+rank);
}

}