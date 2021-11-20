package models.traders;

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
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
