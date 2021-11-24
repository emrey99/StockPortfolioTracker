package core;


import core.interfaces.Controller;
import models.stocks.BaseStock;
import models.traders.BaseTrader;

import java.util.*;
import java.util.stream.Collectors;

import static common.constants.ExceptionMessages.*;
import static common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Map<Integer, BaseTrader> traders;
    private Map<Integer, BaseStock> stocks;

    public ControllerImpl() {
        this.traders = new HashMap<>();
        this.stocks = new HashMap<>();
    }


    @Override
    public String addTrader(int id, String name, int budget) {

        checkTraderId(id);
        BaseTrader trader = new BaseTrader(id, name, budget);
        traders.put(id, trader);
        return TRADER_ADDED;

    }

    @Override
    public String removeTrader(int id) {

        traders.remove(id);
        return TRADER_REMOVED;

    }

    @Override
    public String buyStock(int stockId, int traderId, String stockName, double stockPrice, int stockQuantity) {

        BaseStock stock;

        if (!this.traders.containsKey(traderId)) {
            throw new IllegalArgumentException(NOT_EXISTING_TRADER);
        } else {
            double totalPriceOfStock = stockPrice * stockQuantity;
            double currentBudget = this.traders.get(traderId).getBudget();
            if (currentBudget < totalPriceOfStock) {
                throw new IllegalArgumentException(NOT_ENOUGH_MONEY_TO_BUY);

            } else {
                this.traders.get(traderId).setBudget(currentBudget - totalPriceOfStock);
                stock = new BaseStock(stockName, stockPrice, stockQuantity);
                traders.get(traderId).addStock(stock);
                return STOCK_BOUGHT;
            }
        }
    }

    @Override
    public List<BaseTrader> theRichestTrader(double budget) {
        return traders.values().stream()
                .filter(c -> c.getBudget() > budget)
                .sorted(Comparator.comparing(BaseTrader::getBudget).reversed())
                .collect(Collectors.toList());
    }


    public void checkTraderId(int id) {

        if (this.traders.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_TRADER);
        }
    }



}



