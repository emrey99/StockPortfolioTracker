package core;

import common.enums.CommandType;
import core.interfaces.Controller;

public class CommandFactory {

    private final Controller controller;
    private final String[] data;

    public CommandFactory(Controller controller, String[] data) {
        this.controller = controller;
        this.data = data;
    }

    public String from(CommandType commandType) {
        switch (commandType) {
            case addTrader:
                return this.controller.addTrader(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
            case removeTrader:
                return this.controller.removeTrader(Integer.parseInt(data[0]));
            case buyStock:
                return this.controller.buyStock(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]));
//            case theRichestTrader:
//                return this.controller.theRichestTrader(Double.parseDouble(data[0]));
            case priceChange:
                return this.controller.priceChange(data[0], Float.parseFloat(data[1]));
            default:
                throw new IllegalArgumentException("Command with this name does not exist");
        }
    }
}
