package hdd.demo.java8.entity;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

import hdd.demo.java8.util.DemoUtil;
import lombok.Data;

/**
 * 班级
 *
 * @author huangqiaowei
 * @create 2018-12-01 11:52
 **/
@Data
public class Clbum {

    private static final String[] DEFAULT_NAME = { "1年级", "2年级", "3年级", "4年级", "5年级", "6年级" };

    private static final Map<Long, String> DEFAULT_CODE = ImmutableMap.<Long, String> builder().put(1L, "A")
        .put(2L, "A").put(3L, "B").put(4L, "B").put(5L, "C").put(6L, "C").build();

    /**
     * 班级id
     */
    private Long id;

    /**
     * 班级名称
     */
    private String name;

    /**
     * A班 B班 C班
     */
    private String code;

    /**
     * 学生
     */
    private List<Student> students;

    /**
     * 初始化数据
     *
     * @return
     */
    public static List<Clbum> init() {
        List<Clbum> clbums = Lists.newArrayList();
        for (int i = 0; i < DEFAULT_NAME.length; i++) {
            Clbum clbum = new Clbum();
            clbum.setId((long) i);
            clbum.setName(DEFAULT_NAME[DemoUtil.random(0, 6)]);
            clbum.setCode(DEFAULT_CODE.get(clbum.getId()));
            clbums.add(clbum);
        }
        return clbums;
    }

}
