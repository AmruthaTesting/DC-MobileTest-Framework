package com.dcxmobile.utils;

import com.dcxmobile.config.KobitonConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * QTestReporter - Sends test results to qTest after each scenario.
 * Uses qTest REST API with bearer token authentication.
 */
public class QTestReporter {

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final ObjectMapper mapper    = new ObjectMapper();

    /**
     * Reports a test result to qTest.
     *
     * @param testCaseName  Name of the test scenario
     * @param status        "PASSED" or "FAILED"
     * @param notes         Any notes or error messages
     */
    public static void reportResult(String testCaseName,
                                    String status,
                                    String notes) {
        String token     = KobitonConfig.getQTestBearerToken();
        String projectId = KobitonConfig.getQTestProjectId();
        String suiteId   = KobitonConfig.getQTestSuiteId();

        if (token == null || projectId == null || suiteId == null) {
            System.out.println("⚠️  qTest credentials not set. Skipping report.");
            return;
        }

        try {
            ObjectNode body = mapper.createObjectNode();
            body.put("name",   testCaseName);
            body.put("status", status);
            body.put("note",   notes != null ? notes : "");

            String url = KobitonConfig.getQTestApiUrl()
                + "/api/v3/projects/" + projectId
                + "/test-runs?parentId=" + suiteId
                + "&parentType=test-suite";

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                    mapper.writeValueAsString(body)))
                .build();

            HttpResponse<String> response = httpClient.send(
                request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200 || response.statusCode() == 201) {
                System.out.println("✅ qTest reported: " + testCaseName
                    + " → " + status);
            } else {
                System.out.println("⚠️  qTest response: " + response.statusCode()
                    + " " + response.body());
            }

        } catch (Exception e) {
            System.out.println("⚠️  qTest reporting failed: " + e.getMessage());
        }
    }
}
