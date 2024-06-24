package ybigta.us.controller;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
@RestController
public class SmsCertificationController {

    // 자체 default Service
    final DefaultMessageService messageService;

    public SmsCertificationController() {
    public SmsCertificationController(
            @Value("${coolsms.api.key}") String apiKey,
            @Value("${coolsms.api.secret}") String apiSecret,
            @Value("${coolsms.api.provider}") String apiProvider) {
        // Message 전송 API KEY
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecret, apiProvider);
    }

    // 메세지 전송 API
    @PostMapping ("/sendSMS")
    public SingleMessageSentResponse sendOne (@RequestParam String to, @RequestParam String verificationCode) {
        Message message=new Message();
        // 발신번호 및 수신번호는 "-"뺀 01012345678 형태로 입력
        
        // 발신번호
        message.setFrom("01073083661");
        
        // 수신번호
        message.setTo(to);
        
        // Message 텍스트
        message.setText("[SMS인증 테스트 중] 아래의 인증번호를 입력해주세요\n" + verificationCode);
        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        return response;
    }
}
