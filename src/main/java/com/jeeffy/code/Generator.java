package com.jeeffy.code;

import com.jeeffy.code.bean.Model;
import com.jeeffy.code.constant.Const;
import com.jeeffy.code.util.*;

import java.util.List;

public class Generator {

	public static void main(String[] args) throws Exception {
        List<String> types = PropertiesUtil.getLayers();

		FileUtil.mkdirs(types);
        List<String> tables = PropertiesUtil.getTables();

        for(String table : tables){
            if(DBUtil.getIdMap(table).size() > 0){
                Model model = ModelBuilder.build(table);
                for (String type : types){
                    FreemarkerUtil.process(model, type);
                }
                System.out.println(table + " has been generated.");
            }else {
                System.err.println(table + " has not id, ignore.");
            }
        }


	}
}
