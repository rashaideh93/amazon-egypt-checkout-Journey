package org.example.core.selenium_drivers;


import org.example.core.enums.HeadlessStrategyOperator;

/**
 * The type Headless executor.
 */
public class HeadlessExecutor {

    private final HeadlessStrategyOperator headlessStrategyOperator;

    /**
     * Instantiates a new Headless executor.
     *
     * @param headlessStrategyOperator the headless strategy operator
     */
    public HeadlessExecutor(HeadlessStrategyOperator headlessStrategyOperator) {
        this.headlessStrategyOperator = headlessStrategyOperator;
    }

    /**
     * Execute.
     */
    public void execute() {
        headlessStrategyOperator.execute();
    }
}
