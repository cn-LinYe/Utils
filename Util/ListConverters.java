import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 英文逗号分隔的字符串数据与List类型的转换器
 */
public class ListConverters {
    
    private static String convertToDatabaseColumn(List<? extends Object> attribute){
        if(attribute == null){
            return null;
        }else {
            return StringUtils.join(attribute, ",");
        }
    }

    /**
     * "a,b,1" <-互转-> List["a","b","1"]
     */
    public static class StringListConverter implements AttributeConverter<List<String>, String>{
        @Override
        public String convertToDatabaseColumn(List<String> attribute) {
            return ListConverters.convertToDatabaseColumn(attribute);
        }

        @Override
        public List<String> convertToEntityAttribute(String dbData) {
            if(dbData == null){
                return Lists.newArrayList();
            }else {
                return Arrays.stream(dbData.split(",")).collect(Collectors.toList());
            }
        }
    }

    /**
     * "1,2,3" <-互转-> List[1,2,3]
     */
    public static class LongListConverter implements AttributeConverter<List<Long>, String>{
        @Override
        public String convertToDatabaseColumn(List<Long> attribute) {
            return ListConverters.convertToDatabaseColumn(attribute);
        }

        @Override
        public List<Long> convertToEntityAttribute(String dbData) {
            if(dbData == null){
                return Lists.newArrayList();
            }else {
                return Arrays.stream(dbData.split(","))
                        .map(str -> {
                            if (StringUtils.isBlank(str)){
                                return null;
                            }else{
                                return Long.parseLong(str);
                            }
                        })
                        .collect(Collectors.toList());
            }
        }
    }

    /**
     * "1.2,2.0,3.3333" <-互转-> List[1.2,2.0,3.3333]
     */
    public static class DoubleListConverter implements AttributeConverter<List<Double>, String>{
        @Override
        public String convertToDatabaseColumn(List<Double> attribute) {
            return ListConverters.convertToDatabaseColumn(attribute);
        }

        @Override
        public List<Double> convertToEntityAttribute(String dbData) {
            if(dbData == null){
                return Lists.newArrayList();
            }else {
                return Arrays.stream(dbData.split(","))
                        .map(str -> {
                            if (StringUtils.isBlank(str)){
                                return null;
                            }else{
                                return Double.parseDouble(str);
                            }
                        })
                        .collect(Collectors.toList());
            }
        }
    }

    /**
     * "1.2,2.0,3.3333" <-互转-> List[1.2,2.0,3.3333]
     */
    public static class FloatListConverter implements AttributeConverter<List<Float>, String>{
        @Override
        public String convertToDatabaseColumn(List<Float> attribute) {
            return ListConverters.convertToDatabaseColumn(attribute);
        }

        @Override
        public List<Float> convertToEntityAttribute(String dbData) {
            if(dbData == null){
                return Lists.newArrayList();
            }else {
                return Arrays.stream(dbData.split(","))
                        .map(str -> {
                            if (StringUtils.isBlank(str)){
                                return null;
                            }else{
                                return Float.parseFloat(str);
                            }
                        })
                        .collect(Collectors.toList());
            }
        }
    }

    /**
     * "1,2,3" <-互转-> List[1,2,3]
     */
    public static class IntegerListConverter implements AttributeConverter<List<Integer>, String>{
        @Override
        public String convertToDatabaseColumn(List<Integer> attribute) {
            return ListConverters.convertToDatabaseColumn(attribute);
        }

        @Override
        public List<Integer> convertToEntityAttribute(String dbData) {
            if(dbData == null){
                return Lists.newArrayList();
            }else {
                return Arrays.stream(dbData.split(","))
                        .map(str -> {
                            if (StringUtils.isBlank(str)){
                                return null;
                            }else{
                                return Integer.parseInt(str);
                            }
                        })
                        .collect(Collectors.toList());
            }
        }
    }
}
