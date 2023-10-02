7U.
We would like to work in the field of communications security (encrypting and decrypting messages using basic cyphers like caesar's 
cypher and control access to who will see the encrypted or non encrypted information ).


link to the documentation : https://api.slack.com/docs  .


screenshot of using hoppscotch: ![img_3.png](img_3.png)  .
![img_4.png](img_4.png)
![Screenshot 2023-10-01 at 10.29.20 PM.png](..%2F..%2FDesktop%2FScreenshots%2FScreenshot%202023-10-01%20at%2010.29.20%20PM.png)
![Screenshot 2023-10-01 at 11.25.54 PM.png](..%2F..%2FDesktop%2FScreenshots%2FScreenshot%202023-10-01%20at%2011.25.54%20PM.png)

example output :
ChatPostMessageResponse(ok=false, warning=null, error=not_allowed_token_type, needed=null, provided=null,
httpResponseHeaders={date=[Mon, 02 Oct 2023 03:17:06 GMT], content-length=[45], server=[Apache],
expires=[Sat, 26 Jul 1997 05:00:00 GMT], x-envoy-upstream-service-time=[19], vary=[Accept-Encoding],
access-control-allow-headers=[slack-route, x-slack-version-ts, x-b3-traceid, x-b3-spanid, x-b3-parentspanid,
x-b3-sampled, x-b3-flags], x-slack-req-id=[3ecffbbebdb5ae45f749c79974cd0cc8],
x-backend=[main_normal main_canary_with_overflow main_control_with_overflow],
via=[1.1 slack-prod.tinyspeck.com, envoy-www-iad-vmmmdhqf, envoy-edge-cmh-xtebfibh],
referrer-policy=[no-referrer], content-type=[application/json; charset=utf-8],
cache-control=[private, no-cache, no-store, must-revalidate], x-edge-backend=[envoy-www],
x-slack-unique-id=[ZRo2Mv3FdjZZGzmReO7wVAAAABU], x-slack-edge-shared-secret-outcome=[no-match],
x-slack-backend=[r], pragma=[no-cache],
strict-transport-security=[max-age=31536000; includeSubDomains; preload],
access-control-expose-headers=[x-slack-req-id, retry-after], access-control-allow-origin=[*],
x-envoy-attempt-count=[1], x-content-type-options=[nosniff], x-xss-protection=[0], x-robots-tag=[noindex,nofollow],
x-slack-shared-secret-outcome=[no-match], x-server=[slack-www-hhvm-main-iad-hnte]},
deprecatedArgument=null, errors=null, responseMetadata=null, channel=null, ts=null, message=null)


list of technical problems : We created a token and were able to have the Slack app send messages to the channel through
java but then transferred ownership of the app and lost the ability to do so. The error we receive now is
"not_allowed_token_type."
