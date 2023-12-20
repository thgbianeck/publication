package br.com.bieniek.publication.service;

import br.com.bieniek.publication.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "COMMENT";

    public void save(List<Comment> comments, String id) {
        redisTemplate.opsForHash().put(KEY, id, comments);
    }

    public List<Comment> findById(final String id) {
        return (List<Comment>) redisTemplate.opsForHash().get(KEY, id);
    }


}
