package com.example.springbootredis.cache;

import com.alibaba.fastjson2.JSON;
import com.example.springbootredis.Config.RedisCache;
import com.example.springbootredis.Config.RedisKeys;
import com.example.springbootredis.vo.UserLoginVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.springbootredis.Config.RedisCache.HOUR_SIX_EXPIRE;


@Component
@AllArgsConstructor
public class TokenStoreCache {
    private final RedisCache redisCache;

    public void saveUser(String accessToken, UserLoginVO user) {
        String accessTokenKey = RedisKeys.getAccessTokenKey(accessToken);
        String userIdKey = RedisKeys.getUserIdKey(user.getPkId());
        if (redisCache.get(userIdKey) == null) {
            redisCache.delete(String.valueOf(redisCache.get(userIdKey)));
        }
        System.out.println("TokenStoreCache accesstoken = " + accessToken);
        redisCache.set(userIdKey, accessToken, HOUR_SIX_EXPIRE);
        redisCache.set(accessTokenKey, user, HOUR_SIX_EXPIRE);
    }

    public UserLoginVO getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return JSON.toJavaObject(redisCache.get(key), UserLoginVO.class);
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }

    public void deleteUserById(Long id) {
        String userIdKey = RedisKeys.getUserIdKey(id);
        String key = String.valueOf(redisCache.get(userIdKey));
        redisCache.delete(key);
    }

    public void deleteUserByIds(List<Long> ids) {
        List<String> keys = new ArrayList<>();
        for (Long id : ids) {
            String userId = RedisKeys.getUserIdKey(id);
            String key = String.valueOf(redisCache.get(userId));
            keys.add(key);
        }
        redisCache.delete(keys);
    }
}