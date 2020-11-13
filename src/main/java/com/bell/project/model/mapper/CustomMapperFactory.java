package com.bell.project.model.mapper;

import com.bell.project.model.Office;
import com.bell.project.model.User;
import com.bell.project.view.office.OfficeFilter;
import com.bell.project.view.office.OfficeViewSave;
import com.bell.project.view.user.UserView;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

@Service
public class CustomMapperFactory implements FactoryBean<MapperFactory> {

    @Override
    public MapperFactory getObject() {
        MapperFactory factory = new DefaultMapperFactory.Builder()
                .constructorResolverStrategy(null)
                .build();
        factory.classMap(Office.class, OfficeViewSave.class)
                .field("organization.id", "orgId")
                .byDefault()
                .register();
        factory.classMap(User.class, UserView.class)
                .field("document.documentType.name", "documentName")
                .field("document.number", "documentNumber")
                .field("document.date", "documentDate")
                .field("nationality.name", "citizenshipName")
                .field("nationality.code", "citizenshipCode")
                .byDefault()
                .register();
        return factory;
    }

    @Override
    public Class<?> getObjectType() {
        return MapperFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}