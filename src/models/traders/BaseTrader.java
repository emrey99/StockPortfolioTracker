package models.traders;

import models.stocks.BaseStock;


import java.util.ArrayList;
import java.util.List;

import static common.constants.ExceptionMessages.*;

public class BaseTrader implements Trader {

    private int id;
    private String name;
    private double budget;
    private List<BaseStock> stocks;

    public BaseTrader(int id, String name, double budget){
        this.setId(id);
        this.setName(name);
        this.setBudget(budget);
        this.stocks = new ArrayList<>();
    }


    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0){
            throw new IllegalArgumentException(INVALID_TRADER_ID);
        }

        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_TRADER_NAME);
        }

        this.name = name;
    }

    @Override
    public double getBudget() {
        return budget;
    }

    @Override
    public String addStock(BaseStock stock) {
        this.stocks.add(stock);
        return "Stock added in stocks BaseTrader class";

    }

    @Override
    public List<BaseStock> getStocks() {
        return this.stocks;
    }

    public void setBudget(double budget) {
        if (budget <= 0){
            throw new IllegalArgumentException(INVALID_BUDGET);
        }

        this.budget = budget;
    }


}
