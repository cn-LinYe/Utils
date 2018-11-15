package com.money.converters;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 英文逗号分隔的字符串数据与Set类型的转换器
 */
public class SetConverters {

    private static String convertToDatabaseColumn(Set<? extends Object> attribute){
        if(attribute == null){
            return null;
        }else {
            return StringUtils.join(attribute, ",");
        }
    }

    /**
     * "a,b,1" <-互转-> Set["a","b","1"]
     */
    public static class StringSetConverter implements AttributeConverter<Set<String>, String>{
        @Override
        public String convertToDatabaseColumn(Set<String> attribute) {
            return SetConverters.convertToDatabaseColumn(attribute);
        }

        @Override
        public Set<String> convertToEntityAttribute(String dbData) {
            if(dbData == null){
                return Sets.newHashSet();
            }else {
                return Arrays.stream(dbData.split(",")).collect(Collectors.toSet());
            }
        }
    }

    /**
     * "1,2,3" <-互转-> Set[1,2,3]
     */
    public static class LongSetConverter implements AttributeConverter<Set<Long>, String>{
        @Override
        public String convertToDatabaseColumn(Set<Long> attribute) {
            return SetConverters.convertToDatabaseColumn(attribute);
        }

        @Override
        public Set<Long> convertToEntityAttribute(String dbData) {
            if(dbData == null){
                return Sets.newHashSet();
            }else {
                return Arrays.stream(dbData.split(","))
                        .map(str -> {
                            if (StringUtils.isBlank(str)){
                                return null;
                            }else{
                                return Long.parseLong(str);
                            }
                        })
                        .collect(Collectors.toSet());
            }
        }
    }

    /**
     * "1.2,2.0,3.3333" <-互转-> Set[1.2,2.0,3.3333]
     */
    public static class DoubleSetConverter implements AttributeConverter<Set<Double>, String>{
        @Override
        public String convertToDatabaseColumn(Set<Double> attribute) {
            return SetConverters.convertToDatabaseColumn(attribute);
        }

        @Override
        public Set<Double> convertToEntityAttribute(String dbData) {
            if(dbData == null){
                return Sets.newHashSet();
            }else {
                return Arrays.stream(dbData.split(","))
                        .map(str -> {
                            if (StringUtils.isBlank(str)){
                                return null;
                            }else{
                                return Double.parseDouble(str);
                            }
                        })
                        .collect(Collectors.toSet());
            }
        }
    }

    /**
     * "1.2,2.0,3.3333" <-互转-> Set[1.2,2.0,3.3333]
     */
    public static class FloatSetConverter implements AttributeConverter<Set<Float>, String>{
        @Override
        public String convertToDatabaseColumn(Set<Float> attribute) {
            return SetConverters.convertToDatabaseColumn(attribute);
        }

        @Override
        public Set<Float> convertToEntityAttribute(String dbData) {
            if(dbData == null){
                return Sets.newHashSet();
            }else {
                return Arrays.stream(dbData.split(","))
                        .map(str -> {
                            if (StringUtils.isBlank(str)){
                                return null;
                            }else{
                                return Float.parseFloat(str);
                            }
                        })
                        .collect(Collectors.toSet());
            }
        }
    }

    /**
     * "1,2,3" <-互转-> Set[1,2,3]
     */
    public static class IntegerSetConverter implements AttributeConverter<Set<Integer>, String>{
        @Override
        public String convertToDatabaseColumn(Set<Integer> attribute) {
            return SetConverters.convertToDatabaseColumn(attribute);
        }

        @Override
        public Set<Integer> convertToEntityAttribute(String dbData) {
            if(dbData == null){
                return Sets.newHashSet();
            }else {
                return Arrays.stream(dbData.split(","))
                        .map(str -> {
                            if (StringUtils.isBlank(str)){
                                return null;
                            }else{
                                return Integer.parseInt(str);
                            }
                        })
                        .collect(Collectors.toSet());
            }
        }
    }
}
