package com.supertrampai.springbootsimpleactuator.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 20:25 2019/8/30
 * @Modified By:
 */
@Component
public class HealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {return Health.down()
            .withDetail("Error Code", errorCode).build();
}   return Health.up().build();
}
    public int check() {
    // Our logic to check health
    return 0;
    }
}