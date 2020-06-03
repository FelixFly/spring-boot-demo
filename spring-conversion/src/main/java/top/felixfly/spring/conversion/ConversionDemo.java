package top.felixfly.spring.conversion;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.TypeConverter;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.validation.DataBinder;
import top.felixfly.spring.conversion.entity.User;

import java.util.*;

/**
 * 类型转换
 *
 * @author FelixFly <chenglinxu@yeah.net>
 * @date 2020/6/2
 */
public class ConversionDemo {

    public static void main(String[] args) {
        // 类型转换
        // org.springframework.core.convert.converter.Converter 单一类型的转换接口，不支持复合类型
        // org.springframework.core.convert.converter.ConditionalConverter 匹配类型转换
        // org.springframework.core.convert.converter.GenericConverter 复合类型的转换接口
        // org.springframework.core.convert.converter.ConditionalGenericConverter 匹配的复合类型转换接口
        // org.springframework.core.convert.converter.ConverterFactory Converter的创建工厂

        // org.springframework.core.convert.ConversionService 类型转换服务
        // org.springframework.core.convert.support.ConfigurableConversionService 可配置的类型转换服务
        // org.springframework.core.convert.converter.ConverterRegistry 类型服务的转换器


        // webmvc里面是不是用到了这个类型转换？？？
        // org.springframework.http.converter.HttpMessageConverter http信息转换
        // org.springframework.http.converter.GenericHttpMessageConverter 泛型转换


        // 属性复制
        // apache commons BeanUtils
        // apache commons PropertyUtils
        // spring BeanUtils
        // CGLIB BeanCopier
        // orika MapperFacade
        DefaultConversionService conversion = new DefaultConversionService();
        // 字符串转换为数字
        Integer convert = conversion.convert("1111111", Integer.class);
        System.out.println(convert);
        // 集合转数组
        List<String> nums = new ArrayList<>(5);
        nums.add("1111");
        nums.add("222");
        nums.add("333");
        Integer[] convert1 = conversion.convert(nums, Integer[].class);
        System.out.println(Arrays.asList(convert1));

        // 添加自定义的转换器
        conversion.addConverter(new MapToUserConverter());
        // map 转对象
        Map<String, String> userMap = new HashMap<>(4);
        userMap.put("userId", "1111");
        userMap.put("userName", "张三");
        User user = conversion.convert(userMap, User.class);
        System.out.println(user);

        // org.springframework.beans.TypeConverter 类型转换接口
        // 1. Beans Api 实现PropertyEditor
        // 2. ConversionService 进行转换
        // 简单类型转换
        TypeConverter typeConverter = new SimpleTypeConverter();
        Integer integer = typeConverter.convertIfNecessary("11111", Integer.class);
        System.out.println(integer);
        // 复合类型转换
        Integer[] integers = typeConverter.convertIfNecessary(nums, Integer[].class);
        System.out.println(Arrays.asList(integers));

        // 数据绑定
        // org.springframework.validation.DataBinder
        User user1 = new User();
        DataBinder binder = new DataBinder(user1, "user");
        PropertyValue userId = new PropertyValue("userId","2222");
        PropertyValue userName = new PropertyValue("userName","2222");
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(userId);
        propertyValues.addPropertyValue(userName);
        binder.bind(propertyValues);
        System.out.println(user1);
        // Spring MVC 的数据绑定
        // org.springframework.web.method.support.HandlerMethodArgumentResolver 请求方法参数处理器
        // org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor 关联数据绑定
        // org.springframework.web.bind.WebDataBinder Web 数据绑定
        // org.springframework.web.bind.ServletRequestDataBinder Servlet 请求数据绑定
        // org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder 扩展的Servlet请求数据绑定

    }


    private static class MapToUserConverter implements ConditionalGenericConverter {

        @Override
        public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
            // Map 是其父类
            return Map.class.isAssignableFrom(sourceType.getObjectType()) && User.class.equals(targetType.getObjectType());
        }

        @Override
        public Set<ConvertiblePair> getConvertibleTypes() {
            return Collections.singleton(new ConvertiblePair(Map.class, User.class));
        }

        @Override
        public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
            Map<String, String> map = (Map<String, String>) source;
            User user = new User();
            user.setUserId(Integer.valueOf(map.get("userId")));
            user.setUserName(map.get("userName"));
            return user;
        }
    }
}
