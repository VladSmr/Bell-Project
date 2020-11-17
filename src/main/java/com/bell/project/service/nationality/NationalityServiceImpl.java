package com.bell.project.service.nationality;

import com.bell.project.dao.nationality.NationalityDao;
import com.bell.project.model.Nationality;
import com.bell.project.model.mapper.MapperFacade;
import com.bell.project.view.nationality.NationalityView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class NationalityServiceImpl implements NationalityService {

    private final NationalityDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public NationalityServiceImpl(NationalityDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<NationalityView> nationalities() {
        List<Nationality> all = dao.nationalities();
        return mapperFacade.mapAsList(all, NationalityView.class);
    }
}