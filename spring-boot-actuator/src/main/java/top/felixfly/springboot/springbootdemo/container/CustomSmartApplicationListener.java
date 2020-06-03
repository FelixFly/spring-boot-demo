package top.felixfly.springboot.springbootdemo.container;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * 监听所有事件类型
 *
 * @author xcl <xcl@winning.com.cn>
 * @date 2020/5/13
 */
public class CustomSmartApplicationListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("ApplicationListener:" + event.getClass());
    }
}
