
package org.datascienceengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import akka.actor.ActorSystem;

@SpringBootApplication(exclude={ElasticsearchAutoConfiguration.class})
@ComponentScan(basePackages = "org.uptake.datascienceengine")
public class Application {
    
    @Autowired
    private ActorSystem actorSystem;


    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}