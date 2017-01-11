package com.jeeffy.code.util;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;


public class PropertiesUtil {
	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			String path = PropertiesUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			prop.load(new FileInputStream(path + "/generator.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getPackage(){
		String cgpackage = prop.getProperty("package");
		if(cgpackage!=null){
			cgpackage = cgpackage.trim();
		}
		return cgpackage;
	}
	
	public static String getLocation(){
		String location = prop.getProperty("location");
		if(location!=null){
			location = location.trim();
		}
		return location;
	}

    private static String getTableName(){
        String table = prop.getProperty("table.name");
        if(table!=null){
            table = table.trim();
        }
        return table;
    }

    private static boolean useDbGenerator(){
        String flag = prop.getProperty("use.db.generator");
        return Boolean.parseBoolean(flag);
    }

	public static Map<String, String> getBeanId(){
	    if(useDbGenerator()){
            return DBUtil.getPrimaryKey(getTableName());
        }else{
            Map<String, String> map = new LinkedHashMap<>();
            String id = prop.getProperty("bean.id");
            if(id!=null && !"".equals(id.trim())){
                id = id.trim();
                map.put("id", id);
                map.put("idType", getBeanFields().get(id));
            }else{
                map.put("id", "id");
                map.put("idType", getBeanFields().get("id"));
            }

            return map;
        }
	}
	
	/**
	 * @return map key is field name, value is field type
	 */
	public static Map<String, String> getBeanFields(){
        if(useDbGenerator()){
            return DBUtil.getFormatedColumnNameTypeMap(getTableName());
        }else{
            Map<String, String> map = new LinkedHashMap<>();
            String fields = prop.getProperty("bean.fields");

            //use default if bean.id is empty
            String id = prop.getProperty("bean.id");
            if(id==null || "".equals(id.trim())){
                map.put("id", "Integer");
            }

            String[] fieldArr = fields.split(",");
            for(String field : fieldArr){
                if(field.contains(":")){
                    map.put(field.substring(0,field.indexOf(":")).trim(), field.substring(field.indexOf(":")+1).trim());
                }else{
                    map.put(field.trim(), "String");
                }
            }
            return map;
        }

	}
	
	public static String getBeanName(){
        if(useDbGenerator()){
            return StringUtil.format(getTableName());
        }else{
            String bean = prop.getProperty("bean.name");
            if(bean!=null && !"".equals(bean)){
                bean = bean.trim();
            }
            bean = bean.substring(0, 1).toUpperCase()+bean.substring(1);
            return bean;
        }

	}
	
	public static String getDbType(){
		String type = prop.getProperty("db.type");
		if(type!=null && !"".equals(type.trim())){
			type = type.trim().toLowerCase();
		}{
			type = "mysql";
		}
		return type;
	}
	
	public static String getModule(){
        String str = prop.getProperty("package");
        if(str!=null){
            str = str.trim().substring(str.lastIndexOf(".")+1);
        }
        return str;
    }
}
