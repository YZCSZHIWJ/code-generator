package ${packageName}.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ${packageName}.bean.${ClassName};
import ${packageName}.service.${ClassName}Service;

@RequestMapping(value = "/${className}s")
@RestController
public class ${ClassName}Controller {
	
	@Autowired
	private ${ClassName}Service ${className}Service;
	
	
	@GetMapping
    public List<${ClassName}> list(HttpServletRequest request) {
		return ${className}Service.getByMap(null);
    }
	
	@GetMapping("/{id}")
    public ${ClassName} detail(@PathVariable ${idType} ${id}) {
		return ${className}Service.getById(${id});
    }
    
    @PostMapping
    public ${ClassName} create(${ClassName} ${className}) {
		return ${className}Service.create(${className});
    }

    @PutMapping("/{id}")
    public ${ClassName} update(${ClassName} ${className}) {
		return ${className}Service.update(${className});
    }
    
    @DeleteMapping("/{id}")
    public int delete(@PathVariable ${idType} ${id}) {
		return ${className}Service.delete(${id});
    }
    
}