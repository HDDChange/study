package hdd.demo.java8.collectorsAPI;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 自定义收集器
 *
 * @author huangqiaowei
 * @create 2018-12-06 17:31
 **/
public class MyCollector<T> implements Collector<T, List<T>, List<T>> {

    /**
     * 创建新的结果容器
     */
    @Override
    public Supplier<List<T>> supplier() {
        return Lists::newArrayList;
    }

    /**
     * 将遍历过的元素添加到结果容器中
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    /**
     * 合并两个结果容器
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    /**
     * 对结果容器应用最终转换
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    /**
     * 定义收集器对行为
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}
