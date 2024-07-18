package helper;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import static helper.Endpoint.*;

public class QaseReport {
    public static void reportTestResult(String testCaseId, boolean isSuccess, String comment) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(HOST_QASE_IO + "/result/" + PROJECT_CODE + "/" + testCaseId);

            post.setHeader("Content-Type", "application/json");
            post.setHeader("Token", QASE_API_TOKEN);

            String status = isSuccess ? "passed" : "failed";

            String json = String.format("{\"status\": \"%s\", \"comment\": \"%s\"}", status, comment);
            post.setEntity(new StringEntity(json));

            try (CloseableHttpResponse response = client.execute(post)) {
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Response from Qase: " + responseBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
