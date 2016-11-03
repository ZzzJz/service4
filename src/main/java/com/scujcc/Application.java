
package com.scujcc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
@SpringBootApplication
@EnableCaching
@Configuration
@ComponentScan("com.scujcc")
public class Application implements CommandLineRunner{
	@Autowired
	private CrimeRepository repository;
	
	
	public CacheManager cacheManager(){
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}
	
	public EhCacheManagerFactoryBean ehCacheCacheManager(){
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}
    
	public static void main(String[] args){
		SpringApplication.run(Application.class,args);
}

	@Override
	public void run(String... args) throws Exception{
		repository.deleteAll();


		repository.save(new Crime("1","title1","11s","no",false));
        repository.save(new Crime("2","title2","22s","no",true));
		repository.save(new Crime("3","title3","33s","no",false));
		repository.save(new Crime("4","title4","44s","no",true));

		System.out.println("-------1----");
     	

		System.out.println("use forEach method:");
		for(Crime crime:repository.findAll())
			System.out.println(crime);
        

		System.out.println("if remove 2,use forEach:");
       // repository.removeCrimeById(2l);
		for(Crime crime:repository.findAll())
			System.out.println(crime);
		

		System.out.println("-------4----");
	
		System.out.println("update 4:");
        
       
        
        //repository.update(new Crime(4l,"afterupdate4","44","yes",false));
		System.out.println("-------4----");

		
		


         

}

}

