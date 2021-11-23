package core.interfaces;

public interface Controller {

    String addTrader(int id,String name,int budget);
    String removeTrader(int id);
    String buyStock(String traderName,String stockName,double stockPrice,int stockQuantity);


}
