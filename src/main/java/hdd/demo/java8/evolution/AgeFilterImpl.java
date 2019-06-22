package hdd.demo.java8.evolution;

import hdd.demo.java8.entity.Student;

/**
 * 学生年龄筛选
 *
 * @author huangqiaowei
 * @create 2018-12-04 11:18
 **/
public class AgeFilterImpl implements Filter {

    /**
     * 过滤
     * 
     * @param student
     * @return
     */
    @Override
    public boolean studentFilter(Student student) {
        return student.getAge() > 18;
    }
}
