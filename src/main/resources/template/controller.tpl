package ${packageName}.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ${packageName}.bean.${ClassName};
import ${packageName}.service.${ClassName}Service;

@RequestMapping(value="/${className}s")
@RestController
public class ${ClassName}Controller {
	
	@Autowired
	private ${ClassName}Service ${className}Service;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public List<${ClassName}> list(HttpServletRequest request){
		return ${className}Service.getByMap(null);
    }
	
	@RequestMapping(value="/{${id}}", method = RequestMethod.GET)
    public ${ClassName} detail(@PathVariable ${idType} ${id}){
		return ${className}Service.getById(${id});
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ${ClassName} create(@RequestBody ${ClassName} ${className}){
		return ${className}Service.create(${className});
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ${ClassName} update(@RequestBody ${ClassName} ${className}){
		return ${className}Service.update(${className});
    }
    
    @RequestMapping(value="/{${id}}", method = RequestMethod.DELETE)
    public int delete(@PathVariable ${idType} ${id}){
		return ${className}Service.delete(${id});
    }
    
}