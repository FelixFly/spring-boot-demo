package top.felixfly.springboot.springbootdemo.lifecycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author xcl <xcl@winning.com.cn>
 * @date 2020/5/13
 */
@Component
public class CustomLifeCycle implements SmartLifecycle {

    private volatile boolean start = false;

    @Override
    public void start() {
        System.out.println("CustomLifeCycle开始");
        start = true;
    }

    @Override
    public void stop() {
        System.out.println("CustomLifeCycle关闭");
        start = false;
    }

    @Override
    public boolean isRunning() {
        return start;
    }

}


