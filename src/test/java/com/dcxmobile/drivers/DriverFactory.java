package com.dcxmobile.drivers;

import com.dcxmobile.config.KobitonConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.URL;

/**
 * DriverFactory - Creates and manages Appium driver sessions on Kobiton.
 * Supports both iOS (XCUITest) and Android (UIAutomator2).
 */
public class DriverFactory {

    private static AppiumDriver driver;

    public static AppiumDriver getDriver() throws Exception {
        if (driver == null) {
            String platform = KobitonConfig.getPlatform();
            System.out.println("🚀 Initializing " + platform + " driver on Kobiton...");
            if (platform.equalsIgnoreCase("iOS")) {
                driver = createIOSDriver();
            } else {
                driver = createAndroidDriver();
            }
            System.out.println("✅ Driver session started successfully!");
        }
        return driver;
    }

    // ── iOS Driver ───────────────────────────────────────────────
    private static IOSDriver createIOSDriver() throws Exception {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(KobitonConfig.getIOSDeviceName());
        options.setPlatformVersion(KobitonConfig.getIOSPlatformVersion());
        options.setBundleId(KobitonConfig.getIOSBundleId());
        options.setApp(KobitonConfig.getIOSApp());
        options.setCapability("sessionName",
            "DCX iOS Test - " + KobitonConfig.getAppEnvironment());
        options.setCapability("captureScreenshots", true);
        options.setCapability("kobiton:sessionName", "DCX iOS Cucumber");
        options.setCapability("noReset", false);
        options.setCapability("fullReset", false);

        System.out.println("  Device  : " + KobitonConfig.getIOSDeviceName());
        System.out.println("  iOS Ver : " + KobitonConfig.getIOSPlatformVersion());
        System.out.println("  BundleId: " + KobitonConfig.getIOSBundleId());

        return new IOSDriver(new URL(KobitonConfig.getKobitonUrl()), options);
    }

    // ── Android Driver ───────────────────────────────────────────
    private static AndroidDriver createAndroidDriver() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(KobitonConfig.getAndroidDeviceName());
        options.setPlatformVersion(KobitonConfig.getAndroidPlatformVersion());
        options.setAppPackage(KobitonConfig.getAndroidAppPackage());
        options.setAppActivity(KobitonConfig.getAndroidAppActivity());
        options.setApp(KobitonConfig.getAndroidApp());
        options.setCapability("sessionName",
            "DCX Android Test - " + KobitonConfig.getAppEnvironment());
        options.setCapability("captureScreenshots", true);
        options.setCapability("noReset", false);

        System.out.println("  Device     : " + KobitonConfig.getAndroidDeviceName());
        System.out.println("  Android Ver: " + KobitonConfig.getAndroidPlatformVersion());
        System.out.println("  AppPackage : " + KobitonConfig.getAndroidAppPackage());

        return new AndroidDriver(new URL(KobitonConfig.getKobitonUrl()), options);
    }

    // ── Quit Driver ──────────────────────────────────────────────
    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("✅ Driver session closed.");
            } catch (Exception e) {
                System.out.println("⚠️ Error closing driver: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }

    public static boolean isDriverActive() {
        return driver != null;
    }
}
