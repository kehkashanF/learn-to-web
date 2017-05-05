package com.psl.ibm.spec.unit.test;

import java.net.URI;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.persistence.jaxb.BeanValidationMode;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.external.ExternalTestContainerFactory;
import org.glassfish.jersey.test.grizzly.GrizzlyTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;

import com.psl.ibm.spec.beanvalidation.MyApplication;
import com.psl.ibm.spec.dao.Constant;

public class JerseyTestSetup extends JerseyTest {

	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);

		return new MyApplication().property(
				ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
	}

	@Override
	protected void configureClient(final ClientConfig config) {
		super.configureClient(config);

		config.register(MoxyJsonFeature.class);
	
		config.register(new MoxyJsonConfig().property(
				MarshallerProperties.BEAN_VALIDATION_MODE,
				BeanValidationMode.NONE).resolver());
	}

	@Override
	protected URI getBaseUri() {
		final UriBuilder baseUriBuilder = UriBuilder
				.fromUri(super.getBaseUri()).path("trial");
		final boolean externalFactoryInUse = getTestContainerFactory() instanceof ExternalTestContainerFactory;
		return externalFactoryInUse ? baseUriBuilder.path(Constant.EMPLOYEE_PATH).build()
				: baseUriBuilder.build();
	}

	@Override
	protected TestContainerFactory getTestContainerFactory() {

		return new GrizzlyTestContainerFactory();
	}
}
