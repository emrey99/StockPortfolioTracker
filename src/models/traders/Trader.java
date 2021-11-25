package models.traders;

import models.stocks.BaseStock;
import models.stocks.Stock;

import java.util.List;

public interface Trader {

     int getId();

     String getName();

     double getBudget();

     String addStock(BaseStock stock);

     List<BaseStock> getStocks();

}
