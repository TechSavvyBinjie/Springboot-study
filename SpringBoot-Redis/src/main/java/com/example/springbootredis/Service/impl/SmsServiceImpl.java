package com.example.springbootredis.Service.impl;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.example.springbootredis.Config.CloopenConfig;
import com.example.springbootredis.Config.RedisCache;
import com.example.springbootredis.Config.RedisKeys;
import com.example.springbootredis.Service.SmsService;
import com.example.springbootredis.enums.ErrorCode;
import com.example.springbootredis.exception.ServerException;
import com.example.springbootredis.utils.CommonYtuils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class SmsServiceImpl implements SmsService {
    private final CloopenConfig cloopenConfig;
    private final RedisCache redisCache;

    @Override
    public void sendSms(String phone) {
        int  code= CommonYtuils.generateCode();
        redisCache.set(RedisKeys.getSmsKey(phone),code,120);
//        boolean flag=send(phone,code);
//        if(flag) {
//            log.info("短信发送成功：{}", code);
//        }else {
//            log.info("短信发送失败");
//        }
    }

    private boolean send(String phone, int code) {
        try {
            log.info(" ============= 创建短信发送通道中 ============= \nphone is {},code is {}", phone, code);
            String serverIp = cloopenConfig.getServerIp();
            // 请求端口
            String serverPort = cloopenConfig.getPort();
            // 主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
            String accountSId = cloopenConfig.getAccountSId();
            String accountToken = cloopenConfig.getAccountToken();
            // 请使用管理控制台中已创建应用的APPID
            String appId = cloopenConfig.getAppId();
            //创建了一个客户端对象
            CCPRestSmsSDK sdk = new CCPRestSmsSDK();
            //初始化参数
            sdk.init(serverIp, serverPort);
            sdk.setAccount(accountSId, accountToken);
            sdk.setAppId(appId);
            sdk.setBodyType(BodyType.Type_JSON);
            //获取了短信模板
            String templateId = cloopenConfig.getTemplated();
            String[] datas = {String.valueOf(code), "1"};
            //通过 sendTemplateSMS 方法发送短信
            HashMap<String, Object> result = sdk.sendTemplateSMS(phone, templateId, datas, "1234", UUID.randomUUID().toString());
            if ("000000".equals(result.get("statusCode"))) {
                // 正常返回输出data包体信息（map）
                HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
                Set<String> keySet = data.keySet();
                for (String key : keySet) {
                    Object object = data.get(key);
                    log.info("{} = {}", key, object);
                }
            } else {
                // 异常返回输出错误码和错误信息
                log.error("错误码={} 错误信息= {}", result.get("statusCode"), result.get("statusMsg"));
                throw new ServerException(ErrorCode.CODE_SEND_FAIL);
            }
        } catch (Exception e) {
            throw new ServerException(ErrorCode.CODE_SEND_FAIL);
        }
        return true;
    }

}