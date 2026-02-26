package com.dcxmobile.steps;

import com.dcxmobile.drivers.DriverFactory;
import com.dcxmobile.pages.HomePage;
import com.dcxmobile.pages.TaskPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskSteps {

    private AppiumDriver driver;
    private HomePage homePage;
    private TaskPage taskPage;

    private void initPages() throws Exception {
        driver   = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        taskPage = new TaskPage(driver);
    }

    @When("I navigate to Tasks screen")
    public void i_navigate_to_tasks() throws Exception {
        initPages();
        homePage.navigateToTasks();
    }

    @Then("I should see tasks with priority labels")
    public void i_should_see_tasks_with_priorities() throws Exception {
        initPages();
        assertThat(taskPage.isTasksScreenVisible())
            .as("Tasks screen should be visible")
            .isTrue();
        System.out.println("  ✅ Tasks screen is visible!");
    }

    @Then("I should see {string} priority tasks")
    public void i_should_see_priority_tasks(String priority) throws Exception {
        initPages();
        boolean visible = switch (priority) {
            case "Urg" -> taskPage.isUrgentTaskVisible();
            case "Med" -> taskPage.isMediumTaskVisible();
            case "Low" -> taskPage.isLowTaskVisible();
            default    -> throw new IllegalArgumentException(
                "Unknown priority: " + priority);
        };
        assertThat(visible)
            .as(priority + " priority tasks should be visible")
            .isTrue();
        System.out.println("  ✅ " + priority + " priority tasks visible!");
    }

    @Then("I should see {string} field on the task form")
    public void i_should_see_task_field(String fieldName) throws Exception {
        initPages();
        boolean visible = switch (fieldName) {
            case "Subject (required)"     -> taskPage.isSubjectFieldVisible();
            case "Description (required)" -> taskPage.isDescriptionFieldVisible();
            case "Priority"               -> taskPage.isPriorityFieldVisible();
            case "Type"                   -> taskPage.isTypeFieldVisible();
            default -> throw new IllegalArgumentException(
                "Unknown field: " + fieldName);
        };
        assertThat(visible)
            .as(fieldName + " should be visible on task form")
            .isTrue();
        System.out.println("  ✅ Task field visible: " + fieldName);
    }
}
