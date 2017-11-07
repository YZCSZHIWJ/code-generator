package ${packageName}.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import ${packageName?substring(0, packageName?last_index_of("."))}.BaseTest;
import ${packageName}.bean.${classType};


public class ${classType}ServiceTest extends BaseTest {

    private static ${idType} id = null;

    @Autowired
    ${classType}Service ${className}Service;

    @Test
    public void testList() {
        ${classType} ${className} = new ${classType}();
        Page<${classType}> contracts = ${className}Service.list(${className}, 0);
        Assert.assertNotNull(contracts);
    }

    @Test
    public void testGet() {
        ${classType} ${className} = ${className}Service.get(id);
        Assert.assertNotNull(${className});
    }

    @Test
    public void testSave() {
        ${classType} ${className} = new ${classType}();
        <#list fields as field>
        ${className}.set${field.fieldName?cap_first}(null);
        </#list>
        ${className}Service.save(${className});
    }

    @Test
    public void testDelete() {
        ${className}Service.delete(id);
    }

}