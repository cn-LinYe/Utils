
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.persistence.AttributeConverter;

/**
 * 将数据以JSON字符串存库/从JSON字符串数据读库转换为JSONObject的转换器
 */
public class JSONObjectConverter implements AttributeConverter<JSONObject, String> {
    @Override
    public String convertToDatabaseColumn(JSONObject attribute) {
        if(attribute == null){
            return null;
        }else {
            return JSON.toJSONString(attribute);
        }
    }

    @Override
    public JSONObject convertToEntityAttribute(String dbData) {
        if(dbData == null){
            return null;
        }else {
            return JSON.parseObject(dbData);
        }
    }
}
