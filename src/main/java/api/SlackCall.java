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
        final String token = "xapp-1-A05UP0UAYD8-5961189432647-556e448254a0da328e18c98745c27beefb50ebf937b077659120086054b8522a";
        final String channelId = "C05UNTBFKMH";
        MethodsClient methods = slack.methods(token);
        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel(channelId)
                .text("Hello there")
                .build();
        ChatPostMessageResponse response = methods.chatPostMessage(request);
        System.out.println(response);
        System.out.println("The result of the request was a sent message of 'Hello there' to the Slack channel with" +
                " the channel id C05UNTBFKMH.");
    }
}