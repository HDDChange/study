package hdd.demo.java8.streamAPI;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import hdd.demo.java8.entity.Clbum;
import hdd.demo.java8.entity.Student;

/**
 * 分组
 *
 * @author huangqiaowei
 * @create 2018-12-04 11:51
 **/
public class StreamAPI {

    /**
     * 测试
     *
     * @param args
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {
        // 中间流
        intermediateFlow();

        // Lambda 语法

        Function function = o -> new Student();
        // 谓词
        Predicate predicate = o -> false;
        // 非
        predicate.negate();
        // 与
        predicate.and(predicate);
        // 或
        predicate.or(predicate);

        // 组合函数 之前 f(g(x))
        function.compose(function);
        // 之后 g(f(x))
        function.andThen(function);

        List<Student> students = Student.init(100);

        // 最大、最小、排序
        // students.stream().max(Comparator.comparing(function).reversed());
        // students.stream().sorted(Comparator.comparing(function));

        // 生成流 有限流
        Stream.builder().add(1).build();
        List<Integer> integers = Arrays.asList(1, 2, 3);

        Stream.of(students);
        Stream.of(students, students);
        // 无限流
        Stream.generate(Clbum::init);
        Stream.iterate(0, n -> n + 1);

    }

    /**
     * 中间流
     */
    @SuppressWarnings("all")
    public static void intermediateFlow() {

        List<Student> students = Student.init(100);
        students.add(null);
        // 过滤
        students.stream().filter(Objects::nonNull);

        // 去重
        students.stream().distinct();

        // 排序
        students.stream().sorted();

        // 切片
        students.stream().skip(1).limit(2);

        // 映射
        students.stream().map(Student::getAge);
        List<List<Student>> lists = Lists.newArrayList(students, students);
        lists.stream().flatMap(Stream::of);

        // 特殊的map
        students.stream().peek(student -> student.setName("我执行过peek方法"));

        // 数值流 减少不必要的 装箱拆箱操作
        students.stream().mapToInt(Student::getAge);
        students.stream().mapToLong(Student::getId);
    }

    /**
     * 终端流
     */
    @SuppressWarnings("all")
    public static void terminalFlow() {
        List<Student> students = Student.init(100);

        // 循环
        students.stream().forEach(student -> {
            System.out.printf("我是代码块");
        });

        // 查找
        students.stream().findFirst();
        students.stream().findAny();

        // 匹配
        students.stream().allMatch(Objects::nonNull);
        students.stream().anyMatch(Objects::isNull);
        students.stream().noneMatch(Objects::isNull);

        // 规约
        students.stream().reduce((student, student1) -> student);
        students.stream().reduce(new Student(), (student, student2) -> student);

        // 最大、最小
        students.stream().max(Comparator.comparing(Student::getAge));
        students.stream().min(Comparator.comparing(Student::getAge));

        // 收集
        students.stream().collect(Collectors.toList());
    }

    /**
     * 流收集器
     */
    @SuppressWarnings("all")
    public static void collectors() {
        List<Student> students = Student.init(100);

        // 收集List
        students.stream().collect(Collectors.toList());

        // 收集成Set
        students.stream().collect(Collectors.toSet());

        // 收集成map
        Map<Long, Student> studentMap = Maps.newHashMap();
        students.stream().collect(Collectors.toMap(Student::getId, Function.identity()));
        students.stream().collect(Collectors.toMap(Student::getId, Function.identity(), (k1, k2) -> k1));
        students.stream()
            .collect(Collectors.toMap(Student::getId, Function.identity(), (k1, k2) -> k1, () -> studentMap));

        // 求数量和
        students.stream().collect(Collectors.counting());

        // 最大、最小
        students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
        students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));

        // 求和
        students.stream().collect(Collectors.summingInt(Student::getAge));

        // 求平均
        students.stream().collect(Collectors.averagingInt(Student::getAge));

        // 统计值 最大、最小、平均、和
        students.stream().collect(Collectors.summarizingInt(Student::getAge));

        // 连接字符串
        students.stream().map(Student::getName).collect(Collectors.joining());

        // 分组
        students.stream().collect(Collectors.groupingBy(Student::getAge));
        // 多级分组
        students.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(Student::getGender)));
        // 按分组收集数据
        students.stream().collect(
            Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getName, Collectors.joining())));

        // 分区
        students.stream().collect(Collectors.partitioningBy(o -> o.getGender() == 1 ? true : false));

    }

    /**
     * 并行流
     */
    @SuppressWarnings("all")
    private void parallelStream() {
        List<Student> students = Student.init(100);

        // 使用并行流
        students.parallelStream();

        // 普通流与并行流之间对转换
        students.stream().parallel();
        students.parallelStream().sequential();

    }
}
