package core.interfaces;

public interface Controller {

    String addTrader(int id,String name,int budget);
    String removeTrader(int id);
    String buyStock(int stockId,int traderId,String stockName,double stockPrice,int stockQuantity);
//    String theRichestTrader(double budget);


}
