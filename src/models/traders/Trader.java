package models.traders;

import models.stocks.Stock;

public interface Trader {

     int getId();

     String getName();

     double getBudget();

     String addStock(Stock stock);

}
