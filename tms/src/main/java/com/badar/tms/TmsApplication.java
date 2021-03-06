package com.badar.tms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.badar.tms.enumrations.TicketStatuses;
import com.badar.tms.models.TStatuses;
import com.badar.tms.models.Tickets;
import com.badar.tms.repositories.TicketRepository;
import com.badar.tms.repositories.TicketStatusRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

@SpringBootApplication
@EnableSwagger2
public class TmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmsApplication.class, args);
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.badar.tms.controller"))              
          .paths(regex("/api.*"))                          
          .build().apiInfo(metaData());                                           
    }
	
	private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Ticket Management System REST API",
                "Demi for Test for Badar Ali",
                "1.0",
                "Terms of service",
                new Contact("Badar Ali", "https://www.linkedin.com/in/badaralishah/", "baddarali07@hotmail.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
	
	@Bean
    public CommandLineRunner mappingDemo(TicketRepository ticket,
                                         TicketStatusRepository status) {
        return args -> {

            Tickets data1 = new Tickets();
            data1.setTitle("Configurations needed to start for project");
            data1.setDescription("Kindly as your manager as per confusion");
            data1.setTimeToSpend("10 hrs");
            data1.setParent(null);;
            
            Tickets data2 = new Tickets();
            data2.setTitle("Test Configration");
            data2.setDescription("Kindly as your manager as per confusion");
            data2.setTimeToSpend("5 hrs");
            data2.setParent(data1);
           
            
            ticket.save(data1);
            
            status.saveAndFlush(new TStatuses( TicketStatuses.OPEN,data1));
            status.saveAndFlush(new TStatuses( TicketStatuses.WORKING,data1));
            status.saveAndFlush(new TStatuses(TicketStatuses.COMPLETE,data1));
            
            ticket.saveAndFlush(data2);
        };
    }

}
