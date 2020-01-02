package hdd.demo.java8.streamAPI;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import hdd.demo.java8.entity.Student;

/**
 * 并行流
 *
 * @author huangqiaowei
 * @create 2018-12-07 11:29
 **/
public class ParallelStreamAPI {

    private static final int DEFAULT_AGE = 18;

    /**
     * 时间记录
     *
     * @param function
     * @param method
     * @param students
     */
    public static void log(Function<List<Student>, List<String>> function, String method, List<Student> students) {
        long start = System.currentTimeMillis();
        function.apply(students);
        System.out.printf("%s : %d \n", method, System.currentTimeMillis() - start);
    }

    /**
     * 普通流
     *
     * @param students
     * @return
     */
    public static List<String> stramTest(List<Student> students) {
        if (CollectionUtils.isNotEmpty(students)) {
            return students.stream().filter(student -> student.getAge() > DEFAULT_AGE).map(Student::getName)
                .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 并行流
     *
     * @param students
     * @return
     */
    public static List<String> parallelStreamTest(List<Student> students) {
        if (CollectionUtils.isNotEmpty(students)) {
            return students.parallelStream().filter(student -> student.getAge() > DEFAULT_AGE).map(Student::getName)
                .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

        List<Student> students = Student.init(10000000);
        // 设置线程池
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");

        for (int i = 0; i < 10; i++) {
            log(ParallelStreamAPI::stramTest, "streamTest", students);
            log(ParallelStreamAPI::parallelStreamTest, "parallelStreamTest", students);
            System.out.printf("\n");
        }

    }
}
