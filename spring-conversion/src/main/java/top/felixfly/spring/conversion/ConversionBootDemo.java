package top.felixfly.spring.conversion;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 类型转换示例
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/6/2
 */
@SpringBootApplication
public class ConversionBootDemo implements ApplicationRunner {

    private static ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = new SpringApplicationBuilder(ConversionBootDemo.class).run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 没有ConversionService 的实现类
        /*ConversionService conversionService = applicationContext.getBeanFactory().getConversionService();
        System.out.println(conversionService);*/
    }
}
