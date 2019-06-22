package hdd.demo.java8.entity;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

import hdd.demo.java8.util.DemoUtil;
import lombok.Data;

/**
 * 学校
 *
 * @author huangqiaowei
 * @create 2018-12-01 13:45
 **/
@Data
public class School {

    private static final String[] DEFAULT_NAME = { "黄冈小学", "衡水小学", "普通小学", "4年级" };

    private static final Map<Long, String> DEFAULT_CODE = ImmutableMap.of(1L, "ZD", 2L, "ZD", 3L, "ZD", 4L, "PT");

    /**
     * 学校id
     */
    private Long id;

    /**
     * 学校名称
     */
    private String name;

    /**
     * 学校编号
     */
    private String code;

    /**
     * 年级
     */
    private List<Grade> grades;

    /**
     * 初始化数据
     *
     * @return
     */
    public static List<School> init() {

        List<School> schools = Lists.newArrayList();
        for (int i = 0; i < DEFAULT_NAME.length; i++) {
            School school = new School();
            school.setId((long) i);
            school.setName(DEFAULT_NAME[DemoUtil.random(0, 3)]);
            school.setCode(DEFAULT_CODE.get(school.getId()));
            schools.add(school);
        }
        return schools;
    }

}
