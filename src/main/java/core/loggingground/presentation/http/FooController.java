package core.loggingground.presentation.http;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

	@GetMapping("/api/foo")
	public ResponseEntity<String> foo() {
		return ResponseEntity
			.status(200)
			.build();
	}
}
