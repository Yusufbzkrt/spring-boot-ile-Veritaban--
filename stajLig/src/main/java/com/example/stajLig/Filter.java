package com.example.stajLig;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.json.JSONObject;

public class Filter {

    private JSONObject jsonObject;
    private SimpleDateFormat simpleDateFormat;

    public Filter(Map<String, String> params) {
        jsonObject = new JSONObject(params);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    public Filter(Map<String, String> params, String dateFormat) {
        jsonObject = new JSONObject(params);
        simpleDateFormat = new SimpleDateFormat(dateFormat);
    }

    public Long getLong(String name) {
        return this.valueExists(name) ? jsonObject.getNumber(name).longValue() : null;
    }
    public Integer getInteger(String name) {
        return this.valueExists(name) ? jsonObject.getNumber(name).intValue() : null;
    }
    public Short getShort(String name) {
        return this.valueExists(name) ? jsonObject.getNumber(name).shortValue() : null;
    }
    public Byte getByte(String name) {
        return this.valueExists(name) ? jsonObject.getNumber(name).byteValue() : null;
    }
    public BigDecimal getBigDecimal(String name) {
        return this.valueExists(name) ? jsonObject.getBigDecimal(name) : null;
    }
    public String getString(String name) {
        return this.valueExists(name) ? jsonObject.getString(name) : null;
    }
    public Boolean getBoolean(String name) {
        String valueStr = this.getString(name);
        return (valueStr != null) ? valueStr.equals("true") : null;
    }

    public String getStringOrDefault(String name,String defaultValue) {
        String  deger= jsonObject.optString(name);
        return  isEmpty(deger)?defaultValue:deger;
    }

    public Date getDateOrDefault(String name, String defaultValue) {
        String valueStr = this.getString(name);
        if (valueStr!=null && "".equalsIgnoreCase(valueStr)) valueStr =null;
        Date value = null;
        try {
            value = simpleDateFormat.parse((valueStr != null) ? valueStr : defaultValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }
    public Date getDateOrMin(String name) {
        return getDateOrDefault(name, "1000-01-01");
    }
    public Date getDateOrMax(String name) {
        return getDateOrDefault(name, "3000-01-01");
    }

    public Integer getIntegerOrDefault(String name, Integer defaultValue) {
        Integer value = getInteger(name);
        return (value != null) ? value : defaultValue;
    }
    public Integer getIntegerOrMin(String name) {
        return getIntegerOrDefault(name, Integer.MIN_VALUE);
    }
    public Integer getIntegerOrMax(String name) {
        return getIntegerOrDefault(name, Integer.MAX_VALUE);
    }

    public Long getLongOrDefault(String name, Long defaultValue) {
        Long value = getLong(name);
        return (value != null) ? value : defaultValue;
    }
    public Long getLongOrMin(String name) {
        return getLongOrDefault(name, Long.MIN_VALUE);
    }
    public Long getLongOrMax(String name) {
        return getLongOrDefault(name, Long.MAX_VALUE);
    }

    public BigDecimal getBigDecimalOrDefault(String name, BigDecimal defaultValue) {
        BigDecimal value = getBigDecimal(name);
        return (value != null) ? value : defaultValue;
    }
    public BigDecimal getBigDecimalOrMin(String name) {
        return getBigDecimalOrDefault(name, new BigDecimal(-Float.MAX_VALUE));
    }
    public BigDecimal getBigDecimalOrMax(String name) {
        return getBigDecimalOrDefault(name, new BigDecimal(Float.MAX_VALUE));
    }

    public boolean shouldFilterRange(String startName, String endName) {
        return this.valueExists(startName) || this.valueExists(endName);
    }

    public boolean valueExists(String name) {
        String value = jsonObject.optString(name, "null");
        return !value.equals("null");
    }

    public Date getDateOrNull(String name){
        String valueStr = this.getString(name);
        Date value = null;

        try {
            if(valueStr != null)
                value = simpleDateFormat.parse(valueStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }
    public boolean isEmpty(final String s) {
        return (s == null || "".equals(s.replace("null","").trim()));}
}