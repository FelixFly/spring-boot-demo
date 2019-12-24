package top.felixfly.springboot.springbootdemo.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 自定义实现健康检查信息
 *
 * @author xcl <xcl@winning.com.cn>
 * @date 2019/12/24
 */
@Component
public class MyHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.up().withDetail("my", "up up up");
    }
}
