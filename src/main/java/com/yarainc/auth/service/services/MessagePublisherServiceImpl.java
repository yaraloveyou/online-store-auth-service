package com.yarainc.auth.service.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class MessagePublisherServiceImpl implements MessagePublisherService {

    private RedisTemplate<String, Object> redisTemplate;
    private ChannelTopic topic;

    @Override
    public void publish(final String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
