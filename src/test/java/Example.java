import java.lang.reflect.Field;

public class Example {

    public static class DynamicBean {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        // 可以添加更多的属性和对应的getter/setter方法
    }



}