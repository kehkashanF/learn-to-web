package com.psl.ibm.spec.beanvalidation;

import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.validation.ValidationConfig;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;

import com.psl.ibm.spec.exceptions.EmployeeExceptionMapper;
import com.psl.ibm.spec.resources.EmployeeResource;

import org.eclipse.persistence.jaxb.BeanValidationMode;
import org.eclipse.persistence.jaxb.MarshallerProperties;

/**
 * Employee application configuration.
 *
 * @author kehkashan_fazal
 */
public class MyApplication extends ResourceConfig {

	public MyApplication() {
		// Resources.
		packages(EmployeeResource.class.getPackage().getName());

		// Validation.
		register(ValidationConfigurationContextResolver.class);
		register(EmployeeExceptionMapper.class);

		// Providers - JSON.
		register(MoxyJsonFeature.class); 
		register(new MoxyJsonConfig()
				.setFormattedOutput(true)
				.property(MarshallerProperties.BEAN_VALIDATION_MODE,
						BeanValidationMode.NONE).resolver());
	}

	/**
	 * Custom configuration of validation. This configuration defines custom:
	 * 
	 * ConstraintValidatorFactory - so that validators are able to inject Jersey
	 * providers/resources.
	 * 
	 * ValidationConfig - Configuration class for Bean Validation provider
	 */
	public static class ValidationConfigurationContextResolver implements
			ContextResolver<ValidationConfig> {

		@Context
		private ResourceContext resourceContext;

		@Override
		public ValidationConfig getContext(final Class<?> type) {
			return new ValidationConfig()
					.constraintValidatorFactory(resourceContext
							.getResource(InjectingConstraintValidatorFactory.class));
		}

	}

}
