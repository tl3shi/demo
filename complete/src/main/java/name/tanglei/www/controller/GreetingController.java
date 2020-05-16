package name.tanglei.www.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import name.tanglei.www.exception.BadRequestException;
import name.tanglei.www.form.UserForm;
import name.tanglei.www.vo.Greeting;
import name.tanglei.www.vo.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Response<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		if (!"tangleithu".equals(name)) {
			throw new BadRequestException("user.notFound");
		}
		return Response.ok(new Greeting(counter.incrementAndGet(), String.format(template, name)));
	}

	@RequestMapping("/user")
	public Response<Greeting> createUser(@Valid @RequestBody UserForm userForm) {
		return Response.ok(new Greeting(counter.incrementAndGet(), String.format(template, userForm.getName())));
	}
}
