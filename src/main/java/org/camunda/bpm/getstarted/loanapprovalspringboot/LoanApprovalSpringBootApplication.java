package org.camunda.bpm.getstarted.loanapprovalspringboot;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication
public class LoanApprovalSpringBootApplication {
	@Autowired
	private RuntimeService runtimeService;

	@EventListener
	private void processPostDeploy(PostDeployEvent event) {
		runtimeService.startProcessInstanceByKey("loanApproval");
	}

	public static void main(String[] args) {
		SpringApplication.run(LoanApprovalSpringBootApplication.class, args);
	}
}
