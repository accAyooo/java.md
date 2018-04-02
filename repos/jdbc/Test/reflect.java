import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午1:10 2018/3/31
 */
public class reflect {
    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 实例对象
        Class personClass = Class.forName("Person");
        Constructor constructor = personClass.getConstructor(int.class, String.class, String.class);
        Person person = (Person) constructor.newInstance(1, "shixiangyu", "nan");

        // 执行person中的eat方法
        Method method = personClass.getMethod("eat");
        method.invoke(person);

        // 执行私有方法
        Method method1 = personClass.getDeclaredMethod("setId", int.class);
        // 设置私有访问权限
        method1.setAccessible(true);
        method1.invoke(person, 5);

        System.out.println(person.getId());
    }
}
