package com.dcxmobile.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * TestRunner - Entry point for all Cucumber BDD tests.
 *
 * To run specific tags:
 *   -Dcucumber.filter.tags="@Login"
 *   -Dcucumber.filter.tags="@Regression"
 *   -Dcucumber.filter.tags="not @ignore"
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features   = "src/test/resources/features",
    glue       = {"com.dcxmobile.steps"},
    plugin     = {
        "pretty",
        "html:build/reports/cucumber/cucumber.html",
        "json:build/reports/cucumber/cucumber.json",
        "junit:build/reports/cucumber/cucumber.xml"
    },
    monochrome = true,
    tags       = "not @ignore"
)
public class TestRunner {
}
