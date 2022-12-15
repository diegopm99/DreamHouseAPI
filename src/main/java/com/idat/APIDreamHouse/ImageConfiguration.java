package com.idat.APIDreamHouse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageConfiguration implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/imagesEdificio/**").addResourceLocations("file:/D:/images/imagesEdificio/");
		registry.addResourceHandler("/imagesDepartamento/**").addResourceLocations("file:/D:/images/imagesDepartamento/");
	}

}
