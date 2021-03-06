package com.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.demo.service.UserLoanAccountServiceImpl;

@SpringBootApplication
@EnableScheduling
public class CustomerLoanApplicationMain implements CommandLineRunner {

	@Autowired
	UserLoanAccountServiceImpl userLoanAccountService;

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	public static void main(String[] args) {
		SpringApplication.run(CustomerLoanApplicationMain.class, args);
	}

	
	@Override public void run(String... args) throws Exception {


		JobParameters params = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(job, params);

		System.out.println("save successfully :");
	}
	 


}
