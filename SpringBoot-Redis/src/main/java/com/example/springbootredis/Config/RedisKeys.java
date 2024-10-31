package com.example.springbootredis.Config;

public class RedisKeys {
    public  static  String getSmsKey(String phone){
        return "sms:captcha"+ phone;
    }
    public static String getAccessTokenKey(String accessToken){return"sys:access:"+accessToken;}
    /**     * 获取用户 ID 密钥     *     * @param id id     * @return {@link String}     */
    public static String getUserIdKey(Long id){return"sys:userId:"+id;}
}
