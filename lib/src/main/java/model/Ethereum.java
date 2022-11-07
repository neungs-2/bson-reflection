package model;

public class Ethereum extends Coin {
    public String addr;
    public String from;
    public String to;

   @Override
   public Type getType() {
       // TODO Auto-generated method stub
       return Type.ETHEREUM;
   }
}
