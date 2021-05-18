package in.nareshit.raghu.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/std")
public class StudentRestController {
	
	@GetMapping("/all")
	public ResponseEntity<String> saveStd()
	{
		return ResponseEntity.ok("Dummy");
	}
}
