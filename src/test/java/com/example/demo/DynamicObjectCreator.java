package com.example.demo;


import org.joda.time.DateTime;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;

public class DynamicObjectCreator {

    public static Object createAndPopulateObject(Class<?> clazz, Map<String, Object> fieldValues) throws Exception {
        Object instance = clazz.newInstance(); // 创建对象实例

        // 获取该类的所有属性描述器
        PropertyDescriptor[] descriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();

        for (PropertyDescriptor descriptor : descriptors) {
            String propertyName = descriptor.getName();

            // 检查是否有对应的值需要设置
            if (fieldValues.containsKey(propertyName)) {
                Method setter = descriptor.getWriteMethod();
                if (setter != null) {
                    // 使用反射调用setter方法设置属性值
                    setter.invoke(instance, fieldValues.get(propertyName));
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) throws Exception {
        //退押金生成pxt订单编号
        DateTime dt = new DateTime();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String number = dt.toString("yyyyMMddHHmmss") + timeStamp.substring(timeStamp.length() - 4, timeStamp.length()) + uuid.substring(0, 11);
        System.out.println("pxt" + number);
    }

//    public static void main(String[] args) throws Exception {
//        Map<String, List<String>> categories = new HashMap<>();
//        categories.put("住宅区",Arrays.asList("高档小区/别墅"));
//        String data = "住宅区/高档小区/别墅";
//
//        if(categories.containsValue(Arrays.asList("高档小区/别墅"))){
//            System.out.println("");
//        }
//        String[] parts = data.split("/", 2);
//        if (parts.length == 2) {
//            String part1 = parts[0];
//            String part2 = parts[1];
//            if(categories.containsKey(part1)){
//                List<String> strings = categories.get(part1);
//                if(strings.contains(part2)){
//                    System.out.println("");
//                }else {
//                    System.out.println("");
//                }
//            }
//        }
//    }
}