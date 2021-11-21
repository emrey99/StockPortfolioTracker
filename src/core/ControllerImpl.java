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

    public void checkTraderId(int id){

        if (traders.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_TRADER);
        }
    }
}



