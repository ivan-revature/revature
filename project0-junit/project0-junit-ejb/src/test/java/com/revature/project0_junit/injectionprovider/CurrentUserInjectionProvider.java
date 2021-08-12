package com.revature.project0_junit.injectionprovider;

import java.lang.reflect.Field;

import org.jboss.seam.annotations.In;

import de.akquinet.jbosscc.needle.injection.InjectionProvider;
import de.akquinet.jbosscc.needle.injection.InjectionTargetInformation;
import com.revature.project0_junit.model.User;
import com.revature.project0_junit.testdata.UserTestdataBuilder;

public class CurrentUserInjectionProvider implements InjectionProvider<User> {

	private User currentUser = new UserTestdataBuilder()
			.withUsername("jfrancis").withFirstname("Jerry")
			.withSurname("Francis").build();

	@Override
	public User getInjectedObject(Class<?> injectionPointType) {
		return currentUser;
	}

	@Override
	public boolean verify(InjectionTargetInformation injectionTargetInformation) {
		Field field = (Field) injectionTargetInformation.getAccessibleObject();
		return injectionTargetInformation.isAnnotationPresent(In.class) && field.getName().equals("currentUser");
	}

	@Override
	public Object getKey(InjectionTargetInformation injectionTargetInformation) {
		return "currentUser";
	}

}
