package hdd.demo.java8.entity;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

import hdd.demo.java8.util.DemoUtil;
import lombok.Data;

/**
 * 年级
 *
 * @author huangqiaowei
 * @create 2018-12-01 13:41
 **/
@Data
public class Grade {

    private static final String[] DEFAULT_NAME = { "1班", "2班", "3班", "4班", "5班", "6班" };

    private static final Map<Long, String> DEFAULT_CODE = ImmutableMap.<Long, String> builder().put(1L, "I")
        .put(2L, "II").put(3L, "III").put(4L, "IV").put(5L, "V").put(6L, "VI").build();

    /**
     * 年级id
     */
    private Long id;

    /**
     * 年级名称
     */
    private String name;

    /**
     * 编号 I II III IV V
     */
    private String code;

    /**
     * 班级
     */
    private List<Class> classes;

    /**
     * 初始化数据
     *
     * @return
     */
    public static List<Grade> init() {
        List<Grade> grades = Lists.newArrayList();
        for (int i = 0; i < DEFAULT_NAME.length; i++) {
            Grade grade = new Grade();
            grade.setId((long) i);
            grade.setName(DEFAULT_NAME[DemoUtil.random(0, 6)]);
            grade.setCode(DEFAULT_CODE.get(grade.getId()));
            grades.add(grade);
        }
        return grades;
    }
}
