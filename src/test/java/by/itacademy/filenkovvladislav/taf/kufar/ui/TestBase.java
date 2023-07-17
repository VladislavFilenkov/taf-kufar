package by.itacademy.filenkovvladislav.taf.kufar.ui;

import by.itacademy.filenkovvladislav.taf.kufar.pages.DriverSingleton;
import by.itacademy.filenkovvladislav.taf.kufar.pages.PageUI;
import by.itacademy.filenkovvladislav.taf.kufar.steps.StepUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected PageUI page;
    protected StepUI step;

    @BeforeEach
    public void warmUp() {
        page = new PageUI();
        step = new StepUI();
        step.preparatoryActions();
    }

    @AfterEach
    public void tearsDown() {
        DriverSingleton.quitDriver();
    }
}
