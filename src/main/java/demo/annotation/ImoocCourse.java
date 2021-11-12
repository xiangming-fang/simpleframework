package demo.annotation;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @ProjectName: simpleframework
 * @Package: demo.annotation
 * @ClassName: ImoocCourse
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/9 13:47
 */
@CourseInfoAnnotation(courseName = "剑指java面试",courseTag = "interview",courseProfile = "很多核心知识")
public class ImoocCourse {

    @PersonInfoAnnotation(name = "翔仔",language = {"java","js","python","shell"},age = 26)
    private String author;

    @CourseInfoAnnotation(courseName = "剑指java面试",courseTag = "interview",courseProfile = "很多核心知识",courseId = 144L)
    public void getCourseInfo(){
        System.out.println("");
    }

}
