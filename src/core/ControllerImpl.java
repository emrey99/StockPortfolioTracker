package core;


import core.interfaces.Controller;
import models.traders.BaseTrader;

import java.util.HashMap;
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


    public void checkTraderId(int id){

        if (this.traders.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_TRADER);
        }
    }
}



