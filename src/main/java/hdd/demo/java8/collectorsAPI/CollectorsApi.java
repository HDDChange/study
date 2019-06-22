package hdd.demo.java8.collectorsAPI;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hdd.demo.java8.entity.Student;

/**
 * 流收集
 *
 * @author huangqiaowei
 * @create 2018-12-06 16:15
 **/
public class CollectorsApi {

    public static void main(String[] args) {

        List<Student> students = Student.init(100);
        // 分组 根据年龄分组
        students.stream().collect(Collectors.groupingBy(Student::getAge));
        // 高级分组
        students.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(Student::getGender)));
        HashMap<Long, Map<Integer, List<Student>>> collect = students.stream().collect(
            Collectors.groupingBy(Student::getClassId, Maps::newHashMap, Collectors.groupingBy(Student::getAge)));
        Map<Integer, List<String>> collect1 = students.stream()
            .collect(Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getName, Collectors.toList())));

        System.out.printf("ok");
    }

}
