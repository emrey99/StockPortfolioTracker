package core;


import core.interfaces.Controller;
import models.traders.BaseTrader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.constants.ExceptionMessages.*;
import static common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Map<Integer, BaseTrader> traders;

    public ControllerImpl() {
        this.traders = new HashMap<>();
    }


    @Override
    public String addTrader(int id, String name, int budget) {

        checkTraderId(id);
        BaseTrader trader = new BaseTrader(id, name, budget);
        traders.put(id,trader);
        return TRADER_ADDED;

    }

    @Override
    public String removeTrader(int id) {

        traders.remove(id);
        return TRADER_REMOVED;

    }

    @Override
    public String buyStock(int traderId, String stockName, double stockPrice, int stockQuantity) {

        if (!this.traders.containsKey(traderId)){
            throw new IllegalArgumentException(NOT_EXISTING_TRADER);
        }else{
            double totalPriceOfStock = stockPrice * stockQuantity;
            double currentBudget = this.traders.get(traderId).getBudget();
            if (currentBudget < totalPriceOfStock){
                throw new IllegalArgumentException(NOT_ENOUGH_MONEY_TO_BUY);
                
            }else {
                this.traders.get(traderId).setBudget(currentBudget-totalPriceOfStock);
            }   return STOCK_BOUGHT;
        }
    }


    public void checkTraderId(int id){

        if (this.traders.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_TRADER);
        }
    }
    
}



