package core;

import core.interfaces.Controller;
import models.traders.BaseTrader;

import java.util.HashMap;
import java.util.Map;

public class ControllerImpl implements Controller {

    private Map<Integer, BaseTrader> traders;

    public ControllerImpl() {
        this.traders = new HashMap<>();
    }


    @Override
    public String addTrader(int id, String name, int budget) {
        if (traders.getClass().getSimpleName().contains(name)) {
            throw new IllegalArgumentException("ranodm");
        }

        BaseTrader trader = new BaseTrader(id, name, budget);
        traders.put(id,trader);
        return "Successfully added";

    }
}



