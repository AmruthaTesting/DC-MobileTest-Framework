package com.dcxmobile.steps;

import com.dcxmobile.drivers.DriverFactory;
import com.dcxmobile.utils.QTestReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * Hooks - Runs before and after every Cucumber scenario.
 * Handles driver setup/teardown and qTest reporting.
 */
public class Hooks {

    @Before(order = 1)
    public void setUp(Scenario scenario) {
        System.out.println("\n================================================");
        System.out.println("▶  SCENARIO : " + scenario.getName());
        System.out.println("   TAGS     : " + scenario.getSourceTagNames());
        System.out.println("================================================");
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        System.out.println("\n================================================");
        System.out.println("✅ SCENARIO : " + scenario.getName());
        System.out.println("   STATUS   : " + scenario.getStatus());
        System.out.println("================================================\n");

        // ── Report to qTest ──────────────────────────────────────
        String status = scenario.getStatus().toString().equals("PASSED")
            ? "PASSED" : "FAILED";

        QTestReporter.reportResult(
            scenario.getName(),
            status,
            scenario.isFailed() ? "Scenario failed" : "All steps passed"
        );

        // ── Close driver ─────────────────────────────────────────
        DriverFactory.quitDriver();
    }
}
