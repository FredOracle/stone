package com.example.demo.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;
import javax.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemcachedClient implements CommandLineRunner {

  @Resource
  private MemcacheConfig memcacheSource;

  private MemcachedClient client = null;

  public MemcachedClient(InetSocketAddress inetSocketAddress) {
  }


  @Override
  public void run(String... args) throws Exception {
    client = new MemcachedClient(new InetSocketAddress(memcacheSource.getIp(), memcacheSource.getPort()));
  }

  public MemcachedClient getClient() {
    return client;
  }
}
