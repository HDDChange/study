package top.hddchange.demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

/**
 * 测试使用Meter
 *
 * @author huangqiaowei
 * @date 2019-06-19 10:13
 **/
public class MeterDemo {

    private Counter counter1;
    private Counter counter2;

    public void init() {
        Metrics.addRegistry(new SimpleMeterRegistry());
        counter1 = Metrics.counter("count", "success", "成功", "method", "方法");

    }

    public static void main(String[] args) {
        MeterDemo meterDemo = new MeterDemo();
        meterDemo.init();
        meterDemo.counter1.increment();
        Meter.Id id = meterDemo.counter1.getId();
        System.out.println(meterDemo.counter1.getId().getTags());

    }

}
