package core;

import common.enums.CommandType;
import core.interfaces.Controller;
import core.interfaces.Engine;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.interfaces.InputReader;
import io.interfaces.OutputWriter;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private InputReader reader;
    private OutputWriter writer;


    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();

    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if ("Close".equals(result)) {
                    break;
                }

            } catch (IOException | IllegalArgumentException | NullPointerException e) {
                result = e.getMessage();
            }

            this.writer.writeLine(result);
        }


    }


    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s");

        CommandType command = CommandType.valueOf(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {

            case addTrader:
                return this.controller.addTrader(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]));
            case removeTrader:
                return this.controller.removeTrader(Integer.parseInt(data[0]));
            case buyStock:
                return this.controller.buyStock(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2],Integer.parseInt(data[3]),Integer.parseInt(data[4]));
//            case theRichestTrader:
//                return this.controller.theRichestTrader(Double.parseDouble(data[0]));
            case priceChange:
                return this.controller.priceChange(data[0],Float.parseFloat(data[1]));



        }

        return null;
    }


}
