package ${packageName}.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ${packageName}.bean.${classType};
import ${packageName}.service.${classType}Service;

@RequestMapping(value = "/${format(className, "-")}s")
@RestController
public class ${classType}Controller {
	
	@Autowired
	private ${classType}Service ${className}Service;
	
	@GetMapping
    public List<${classType}> list(${classType} ${className}) {
		return ${className}Service.list(${className});
    }
	
	@GetMapping("/{${id}}")
    public ${classType} get(@PathVariable ${idType} ${id}) {
		return ${className}Service.get(${id});
    }
    
    @PostMapping
    public ${classType} save(@RequestBody ${classType} ${className}) {
		return ${className}Service.save(${className});
    }

    @PutMapping("/{${id}}")
    public ${classType} update(@RequestBody ${classType} ${className}) {
		return ${className}Service.update(${className});
    }
    
}