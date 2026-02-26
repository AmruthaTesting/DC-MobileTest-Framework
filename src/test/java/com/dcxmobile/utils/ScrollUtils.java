package com.dcxmobile.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

/**
 * ScrollUtils - Helper methods for scrolling on mobile.
 */
public class ScrollUtils {

    // ── Scroll Down ──────────────────────────────────────────────
    public static void scrollDown(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int)(size.height * 0.75);
        int endY   = (int)(size.height * 0.25);
        scroll(driver, startX, startY, startX, endY);
    }

    // ── Scroll Up ────────────────────────────────────────────────
    public static void scrollUp(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int)(size.height * 0.25);
        int endY   = (int)(size.height * 0.75);
        scroll(driver, startX, startY, startX, endY);
    }

    // ── Core Scroll Action ────────────────────────────────────────
    private static void scroll(AppiumDriver driver,
                                int startX, int startY,
                                int endX,   int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
            .addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), startX, startY))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(finger.createPointerMove(Duration.ofMillis(600),
                PointerInput.Origin.viewport(), endX, endY))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(sequence));
    }
}
