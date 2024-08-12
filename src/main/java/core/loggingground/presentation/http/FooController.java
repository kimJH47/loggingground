package core.loggingground.presentation.http;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

	private static final Logger log = LoggerFactory.getLogger(FooController.class);

	@GetMapping("/api/foo")
	public ResponseEntity<String> foo() {
		log.info("foo api");
		return ResponseEntity
			.status(200)
			.build();
	}
}
