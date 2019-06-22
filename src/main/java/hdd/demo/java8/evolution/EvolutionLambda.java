package hdd.demo.java8.evolution;

import com.google.common.collect.Lists;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.util.List;
import java.util.stream.Collectors;

import hdd.demo.java8.entity.Student;

/**
 * Lambda表达式演变
 *
 * @author huangqiaowei
 * @create 2018-12-01 11:25
 **/
public class EvolutionLambda {

    private static final int DEFAULT_AGE = 18;

    /**
     * 阶段1：使用for循环
     * 
     * @param students
     */
    public static List<Student> stageOne(List<Student> students) {

        if (CollectionUtils.isNotEmpty(students)) {
            List<Student> temp = Lists.newArrayList();
            for (Student student : students) {
                // 筛选条件
                if (student.getAge() > DEFAULT_AGE) {
                    temp.add(student);
                }

            }
            return temp;
        }
        return null;
    }

    /**
     * 阶段2：使用过滤器
     * 
     * @param students
     * @return
     */
    public static List<Student> stageTwo(List<Student> students) {
        if (CollectionUtils.isNotEmpty(students)) {
            CollectionUtils.filter(students, new Predicate<Student>() {
                @Override
                public boolean evaluate(Student student) {
                    return student.getAge() > DEFAULT_AGE;
                }
            });
            return students;
        }
        return null;
    }

    /**
     * 阶段3：使用stream流
     * 
     * @param students
     * @return
     */
    public static List<Student> stageThree(List<Student> students) {
        if (CollectionUtils.isNotEmpty(students)) {
            return students.stream().filter(student -> student.getAge() > DEFAULT_AGE).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 测试
     * 
     * @param args
     */
    public static void main(String[] args) {
        List<Student> students = Student.init(100000);

        // 阶段1
        long startOne = System.nanoTime();
        stageOne(students);
        long endOne = System.nanoTime();
        System.out.printf("stageOne,耗时：%tS \n", endOne - startOne);

        // 阶段3
        long startThree = System.nanoTime();
        stageThree(students);
        long endThree = System.nanoTime();
        System.out.printf("stageThree,耗时：%tS \n", endThree - startThree);

        // 阶段2
        long startTwo = System.nanoTime();
        stageTwo(students);
        long endTwo = System.nanoTime();
        System.out.printf("stageTwo,耗时：%tS \n", endTwo - startTwo);

    }

}
