package com.spring.ws.data.first;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/OrderService/*");
	}

	@Bean(name = "OrderService")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema orderSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("OrderService");
		wsdl11Definition.setLocationUri("/OrderService");
		wsdl11Definition.setTargetNamespace("http://www.liverestaurant.com/OrderService/schema");
		wsdl11Definition.setSchema(orderSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema orderSchema() {
		return new SimpleXsdSchema(new ClassPathResource("OrderService.xsd"));
	}
}