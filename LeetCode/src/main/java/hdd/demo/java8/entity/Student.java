package hdd.demo.java8.entity;

import com.google.common.collect.Lists;

import java.util.List;

import hdd.demo.java8.util.DemoUtil;
import lombok.Data;

/**
 * 学生实体类
 *
 * @author huangqiaowei
 * @create 2018-12-01 11:26
 **/
@Data
public class Student {

    /**
     * 默认名称
     */
    private static final String[] DEFAULT_NAME = { "张三", "李四", "王五" };

    /**
     * 学生id
     */
    private Long id;

    /**
     * 学生名称
     */
    private String name;

    /**
     * 班级id
     */
    private Long classId;

    /**
     * 学校id
     */
    private Long schoolId;

    /**
     * 性别 0男 1女
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 初始化student数据
     *
     * @return
     */
    public static List<Student> init(int count) {

        List<Student> students = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            Student student = new Student();
            student.setId((long) i);
            student.setName(DEFAULT_NAME[DemoUtil.random(0, 2)]);
            student.setClassId((long) DemoUtil.random(1, 6));
            student.setSchoolId((long) DemoUtil.random(1, 5));
            student.setGender(DemoUtil.random(0, 1));
            student.setAge(DemoUtil.random(15, 20));
            students.add(student);
        }
        return students;

    }

    public static void main(String[] args) {

    }
}
