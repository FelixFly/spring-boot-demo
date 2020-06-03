package top.felixfly.springboot.springbootdemo.container;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link ApplicationContextInitializer} 加载
 *
 * @author xcl <xcl@winning.com.cn>
 * @date 2020/5/13
 */
public class CustomApplicationContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer: 加载");
    }
}
