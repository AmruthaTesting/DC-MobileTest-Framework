package com.dcxmobile.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * KobitonConfig - Reads all configuration from config.properties
 * and system properties passed via run configuration.
 *
 * NEVER hardcode credentials here.
 * Pass sensitive values via Run Configuration VM options:
 * -Dkobiton.userName=xxx -Dkobiton.apiKey=xxx
 */
public class KobitonConfig {

    private static final Properties props = new Properties();

    static {
        try {
            props.load(new FileInputStream(
                "src/test/resources/config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(
                "Cannot load config.properties: " + e.getMessage());
        }
    }

    // ── Kobiton Credentials (passed via VM options) ──────────────
    public static String getUsername() {
        return System.getProperty("kobiton.userName");
    }

    public static String getApiKey() {
        return System.getProperty("kobiton.apiKey");
    }

    public static String getApiUrl() {
        return props.getProperty("kobiton.apiUrl");
    }

    // ── Platform ─────────────────────────────────────────────────
    public static String getPlatform() {
        return System.getProperty("platform",
               props.getProperty("platform", "iOS"));
    }

    // ── iOS Settings ─────────────────────────────────────────────
    public static String getIOSDeviceName() {
        return System.getProperty("appium.deviceName",
               props.getProperty("ios.deviceName"));
    }

    public static String getIOSPlatformVersion() {
        return System.getProperty("appium.platformVersion",
               props.getProperty("ios.platformVersion"));
    }

    public static String getIOSBundleId() {
        return System.getProperty("appium.bundleId",
               props.getProperty("ios.bundleId"));
    }

    public static String getIOSApp() {
        return System.getProperty("appium.app",
               props.getProperty("ios.app"));
    }

    // ── Android Settings ─────────────────────────────────────────
    public static String getAndroidDeviceName() {
        return System.getProperty("appium.deviceName",
               props.getProperty("android.deviceName"));
    }

    public static String getAndroidPlatformVersion() {
        return System.getProperty("appium.platformVersion",
               props.getProperty("android.platformVersion"));
    }

    public static String getAndroidAppPackage() {
        return System.getProperty("appium.appPackage",
               props.getProperty("android.appPackage"));
    }

    public static String getAndroidAppActivity() {
        return System.getProperty("appium.appActivity",
               props.getProperty("android.appActivity"));
    }

    public static String getAndroidApp() {
        return System.getProperty("appium.app",
               props.getProperty("android.app"));
    }

    // ── App Credentials (passed via VM options) ───────────────────
    public static String getAppUsername() {
        return System.getProperty("app.username");
    }

    public static String getAppPassword() {
        return System.getProperty("app.password");
    }

    public static String getAppEnvironment() {
        return System.getProperty("appium.environment",
               props.getProperty("app.environment", "uat"));
    }

    // ── qTest Settings ───────────────────────────────────────────
    public static String getQTestApiUrl() {
        return props.getProperty("qtest.apiUrl");
    }

    public static String getQTestBearerToken() {
        return System.getProperty("qtest.authorization.bearertoken");
    }

    public static String getQTestProjectId() {
        return System.getProperty("qtest.projectId",
               props.getProperty("qtest.projectId"));
    }

    public static String getQTestSuiteId() {
        return System.getProperty("qtest.testsuite.id");
    }

    // ── Kobiton Full URL Builder ─────────────────────────────────
    public static String getKobitonUrl() {
        return "https://" + getUsername() + ":" + getApiKey()
             + "@api.kobiton.com/wd/hub";
    }
}
