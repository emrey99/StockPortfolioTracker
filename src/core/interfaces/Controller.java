package core.interfaces;

import models.traders.BaseTrader;

import java.util.List;

public interface Controller {

    String addTrader(int id,String name,int budget);
    String removeTrader(int id);
    String buyStock(int stockId,int traderId,String stockName,double stockPrice,int stockQuantity);
    List<BaseTrader> theRichestTrader(double budget);


}
