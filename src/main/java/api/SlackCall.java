package api;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

import java.io.IOException;


public class SlackCall {
    public static void main(String[] args) throws SlackApiException, IOException {
        Slack slack = Slack.getInstance();
        final String token = "xoxb-5987663380993-5998028510032-nOhqvPqcDdzpBKzK02PiwuYs";
        final String channelId = "C05UNTBFKMH";
        MethodsClient methods = slack.methods(token);
        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel(channelId)
                .text("Hello there")
                .build();
        ChatPostMessageResponse response = methods.chatPostMessage(request);
        System.out.println("The result of the request was a sent message of 'Hello there' to the Slack channel with the channel id C05UNTBFKMH.");
    }
}
