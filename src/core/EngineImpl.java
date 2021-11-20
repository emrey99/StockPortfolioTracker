package core;

import core.interfaces.Controller;
import core.interfaces.Engine;

public class EngineImpl implements Engine {
    private Controller controller;

    public EngineImpl() {
        this.controller = new ControllerImpl();

    }

    @Override
    public void run() {


    }
}
