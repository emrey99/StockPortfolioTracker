package models.traders;

import static common.constants.ExceptionMessages.*;

public class BaseTrader implements Trader {

    private int id;
    private String name;
    private int budget;

    public BaseTrader(int id, String name, int budget){
        this.setId(id);
        this.setName(name);
        this.setBudget(budget);
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
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        if (budget <= 0){
            throw new IllegalArgumentException(INVALID_BUDGET);
        }

        this.budget = budget;
    }
}
