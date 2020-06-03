package top.felixfly.springboot.springbootdemo.environment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * {@link EnvironmentPostProcessor} 自定义实现
 *
 * @author xcl <xcl@winning.com.cn>
 * @date 2020/5/12
 */
public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.out.println(environment.getProperty("info.app.encoding"));
        System.out.println(environment.getProperty("info.app.encoding"));
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 15;
    }
}
