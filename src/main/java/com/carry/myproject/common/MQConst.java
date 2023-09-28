package com.carry.myproject.common;

public interface MQConst {

    String smsQueue = "SMS_QUEUE";

    String mailQueue = "MSG_EXCHANGE";

    String msgExchange = "MAIL_QUEUE";

    String smsRoutingKey = "queue.sms";

    String mailRoutingKey = "queue.mail";

    String requestExchange = "REQUEST_EXCHANGE";

    String requestKey = "queue.request";

    String requestQueue = "REQUEST_QUEUE";
}
