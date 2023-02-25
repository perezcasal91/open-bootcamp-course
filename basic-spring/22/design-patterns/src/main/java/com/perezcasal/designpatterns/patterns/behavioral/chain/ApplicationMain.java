package com.perezcasal.designpatterns.patterns.behavioral.chain;

import java.util.ArrayList;

public class ApplicationMain {
    public static void main(String[] args) {
        Dialog dialog = new Dialog("dialog");
        Panel panel = new Panel();
        dialog.add(panel);
        System.out.println(panel.showHelp());
        System.out.println(dialog.showHelp());
    }
}

interface ComponentWithContextualHelp {
    String showHelp();
}

abstract class Component implements ComponentWithContextualHelp {
    private String tooltipText;
    protected Container container;

    @Override
    public String showHelp() {
        if (tooltipText != null) {
            return tooltipText;
        }
        return container.showHelp();
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
}

abstract class Container extends Component {
    protected ArrayList<Container> containers;

    public Container() {
        containers = new ArrayList<>();
    }
    public void add(Container container) {
        containers.add(container);
        container.setContainer(this);
    }
}

class Button extends Component {}

class Panel extends Container {
    String modalHelpText;

    public Panel() {}
    public Panel(String modalHelpText) {
        this.modalHelpText = modalHelpText;
    }
    @Override
    public String showHelp() {
        if (modalHelpText != null) {
            return modalHelpText;
        }
        return container.showHelp();
    }
}

class Dialog extends Container {
    private final String wikiPageUrl;
    public Dialog(String wikiPageUrl) {
        this.wikiPageUrl = wikiPageUrl;
    }
    @Override
    public String showHelp() {
        if (wikiPageUrl != null) {
            return wikiPageUrl;
        }
        return container.showHelp();
    }
}